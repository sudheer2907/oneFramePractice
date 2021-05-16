package oneframe.cucumber.stepdefinitions.seleniumeasy;

import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;
import com.oneframe.cucumber.projectone.seleniumeasypages.HomePage;
import com.oneframe.cucumber.projectone.seleniumeasypages.SimpleFormDemoPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class TestHomePage {

  SimpleFormDemoPage simpleFormDemoPage;
  HomePage homePage;

  @Given("^I launch and login to the application$")
  public void i_launch_and_login_to_the_application() throws Exception {
    WebDriverFactory.openApplication();
    simpleFormDemoPage = new SimpleFormDemoPage();
    simpleFormDemoPage.acceptAnAlert();
    WebDriverFactory.waitForPageToLoad(30);
    homePage = new HomePage();
  }

  @And("^I click on tab (.*)$")
  public void i_click_on_tab(String tabNameString) throws Exception {
    homePage.clickonTab(tabNameString);
  }
}
