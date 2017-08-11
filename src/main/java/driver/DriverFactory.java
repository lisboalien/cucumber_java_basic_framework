package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

/**
 * Created by aline on 14/08/2017.
 * The Driver Factory Class has all the methods that are responsible of handling browser drivers
 */
public class DriverFactory {
    private static WebDriver driver = null;
    /**
     * Getting the properties in config.properties
     */
    private static String language = new PropertyReader().readProperty("language");
    private static String firefoxBinary = new PropertyReader().readProperty("firefox_binary");
    private static String firefoxDriver = new PropertyReader().readProperty("firefox_driver");
    private static String chromeBinary = new PropertyReader().readProperty("chrome_binary");
    private static String chromeDriver = new PropertyReader().readProperty("chrome_driver");

    /**
     * Driver factory constructor
     */
    public DriverFactory() {
        initialize();
    }

    /**
     * Method responsible of initializing a browser driver if there is no one open yet
     */
    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    /**
     * Method that creates a new driver instance depending of the one you informed in config.properties file
     */
    private void createNewDriverInstance() {
        String browser = new PropertyReader().readProperty("browser");
        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxDriver);
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("intl.accept_languages", language);
            driver = new FirefoxDriver(new FirefoxBinary(new File(firefoxBinary)), profile);
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            ChromeOptions options = new ChromeOptions();
            options.setBinary(new File(chromeBinary));
            options.addArguments("--lang=" + language);
            driver = new ChromeDriver(options);
        } else {
            System.out.println("can't read browser type");
        }
    }

    /**
     * Method that returns the current driver
     *
     * @return (WebDriver driver)
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Method that closes the driver that is open
     */
    public void destroyDriver() {
        driver.quit();
        driver = null;
    }
}
