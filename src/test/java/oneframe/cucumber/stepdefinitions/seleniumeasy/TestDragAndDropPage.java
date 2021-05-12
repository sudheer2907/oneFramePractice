package oneframe.cucumber.stepdefinitions.seleniumeasy;

import com.oneframe.cucumber.projectone.seleniumeasypages.DragAndDropProgressBarsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class TestDragAndDropPage {

  DragAndDropProgressBarsPage dragAndDropProgressBarsPage = new DragAndDropProgressBarsPage();
  @And("^I click on sub tab (.*) of progress bars page$")
  public void i_click_on_subtan(String subTabName) {
    dragAndDropProgressBarsPage.clickOnSubTab(subTabName);
  }

  @When("^I move the first slider value to (.*)$")
  public void i_move_the_first_slider_value(int value) throws InterruptedException {
    dragAndDropProgressBarsPage.moveGreySlider(value);
  }
}
