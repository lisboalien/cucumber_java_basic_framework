package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import driver.DriverFactory;
import pages.CommonPage;
import pages.GooglePage;

public class BasicStepsTest extends DriverFactory {

    @Given("^The user enters in google page$")
    public void google_page(){
        new GooglePage(driver).google_page();
    }

    @Then("^He sees google logo$")
    public void google_logo(){
        new GooglePage(driver).google_logo();
    }

    @Given("^There is a window open$")
    public void there_is_a_window_open() {
        new CommonPage(driver).there_is_a_window_open();
    }

    @Then("^Close all windows$")
    public void close_all_windows() {
        new CommonPage(driver).close_all_windows();
        destroyDriver();
    }
}
