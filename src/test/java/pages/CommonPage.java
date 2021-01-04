package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class CommonPage {
    private final WebDriver driver;

    /**
     * Constructor of CommonPage class
     *
     * @param driver (the actual driver)
     */
    public CommonPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method that verifies if there is a browser window open
     */
    public void there_is_a_window_open() {
        Assert.assertTrue("There is no window open.", driver.getWindowHandles().size() >= 1);
    }

    /**
     * Method that closes all the open windows
     */
    public void close_all_windows() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            driver.switchTo().window(window);
            driver.close();
        }
    }
}
