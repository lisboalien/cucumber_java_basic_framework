package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='hplogo']")
    private WebElement googleLogoLocator;

    /**
     * Constructor of the GooglePage class
     *
     * @param driver (the actual driver)
     */
    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void google_page() {
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    public void google_logo() {
        Assert.assertTrue("The logo is not displayed.", googleLogoLocator.isDisplayed());
    }
}
