package oneframe.cucumber.projectone.stepdefinitions.ui;

import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;
import com.oneframe.cucumber.projectone.pages.SimpleFormDemoPage;

import cucumber.api.java.en.Given;

public class TestLogin {

    SimpleFormDemoPage simpleFormDemoPage;

    @Given("^I launch and login to the application$")
    public void i_launch_and_login_to_the_application() {
        WebDriverFactory.openApplication();
        simpleFormDemoPage = new SimpleFormDemoPage();
        simpleFormDemoPage.acceptAnAlert();
        WebDriverFactory.waitForPageToLoad(30);
    }
}
