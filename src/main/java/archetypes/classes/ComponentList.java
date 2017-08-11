package archetypes.classes;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static archetypes.classes.RandomDataGenerator.randInt;

/**
 * Created by lisboalien on 14/08/2017.
 * Class that defines a Component List and it extends
 */
public class ComponentList extends Component {
    private String type;
    private String xpathType;
    private List<WebElement> componentList;

    /**
     * Method that returns the component list
     *
     * @return (List of WebElements)
     */
    public List<WebElement> getComponentList() {
        return componentList;
    }

    /**
     * This method set the component list and the variables that composes it
     *
     * @param formXpath (xpath locator of the list)
     * @param type      (type of the list)
     * @param driver    (WebDriver)
     */
    public void setComponentList(String formXpath, String type, WebDriver driver) {
        setXpath(formXpath);
        setType(type);
        setXpathType();
        this.componentList = driver.findElements(By.xpath(getXpath()));
    }

    /**
     * This method returns a specific element of the list
     * There is an Assert on the catch to show the error in the test report
     *
     * @param name (The name of the element you want to return)
     * @return WebElement of the list
     */
    public WebElement getComponentElement(String name) {
        List<WebElement> componentList = getComponentList();
        WebElement componentElement = null;
        try {
            for (int i = 0; i < componentList.size(); i++) {
                if (name.equals(this.componentList.get(i).getText())) {
                    componentElement = this.componentList.get(i).findElement(By.xpath(getXpath() + "[" + (i + 1) + "]" + getXpathType()));
                    break;
                }
            }
            if (componentElement == null) {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException err) {
            System.out.println(err);
            Assert.fail("The component with value '" + name + "' was not found in " + getType());
        }
        return componentElement;
    }

    /**
     * This method returns the list type
     *
     * @return (String list type)
     */
    public String getType() {
        return type;
    }

    /**
     * This method sets the list type. It can be an enum.
     *
     * @param type (String list type)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method returns the xpath ending based in the list type
     *
     * @return (String xpath)
     */
    public String getXpathType() {
        return xpathType;
    }

    /**
     * This method set xpath ending based on component list type
     * You can select and set these xpath endings based on the system you are testing.
     */
    public void setXpathType() {
        xpathType = "";
    }

    /**
     * This method selects (clicks on) all elements of the list
     */
    public List<WebElement> getClickableElementsList() throws InterruptedException {
        List<WebElement> componentList = getComponentList();
        List<WebElement> clickableElementsList = new ArrayList<WebElement>();
        WebElement componentElement;
        for (int i = 0; i < componentList.size(); i++) {
            String xpath = getXpathType();
            componentElement = this.componentList.get(i).findElement(By.xpath(xpath));
            clickableElementsList.add(componentElement);
        }
        return clickableElementsList;
    }

    /**
     * Method that gets the size of the component list
     * @return (int componentList.size)
     */
    public int getListSize() {
        return componentList.size();
    }

    /**
     * Method that returns a random component element of the list based on the list size
     * @return (WebElement of componentList)
     */
    public WebElement getRandomComponentElement() {
        int rand = randInt(0, getListSize());
        return getComponentList().get(rand);
    }
}
