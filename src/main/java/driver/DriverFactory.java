package driver;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by aline on 18/12/2020.
 * The Driver Factory Class has all the methods that are responsible of handling browser drivers
 */
public class DriverFactory {
    protected static WebDriver driver = null;

    /**
     * Getting the properties in config.properties
     */
    private static Properties props = setup();
    static String language = props.getProperty("language");
    private static String firefoxBinary = props.getProperty("firefox_binary");
    private static String chromeBinary = props.getProperty("chrome_binary");

    /**
     * Driver factory constructor
     */
    public DriverFactory() {
        initialize();
    }

    /**
     * Method responsible of initializing a browser driver if there is no one open yet
     */
    private void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }

    /**
     * Method responsible of getting the system properties out of the properties file
     *
     * @return Properties
     */
    private static Properties setup() {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("src/config.properties")));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return props;
    }

    /**
     * Method that creates a new driver instance depending of the one you informed in config.properties file
     */
    private void createNewDriverInstance() {
        String browser = props.getProperty("browser");
        if (browser.equals("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("intl.accept_languages", language);
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
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
    @AfterClass
    public static void destroyDriver() {
        driver.quit();
        driver = null;
    }
}