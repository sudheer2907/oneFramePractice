package oneframe.cucumber.stepdefinitions.seleniumeasy;

import com.oneframe.cucumber.projectone.seleniumeasypages.Others;
import cucumber.api.java.en.And;
import java.util.concurrent.TimeUnit;

public class TestOthers {

  Others others = new Others();
  @And("^I click on sub tab (.*) of others page$")
  public void i_click_on_subtab(String subTabName) {
    others.clickOnSubtab(subTabName);
  }

  @And("^I drag (.*) to target position$")
  public void i_drag_to_target_position(String str) throws InterruptedException {
    others.dragItemIntoTargetBox(str);
    TimeUnit.SECONDS.sleep(5);
  }
}
