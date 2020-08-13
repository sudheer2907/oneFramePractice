package oneframe.cucumber.projectone.stepdefinitions.ui;

import com.oneframe.cucumber.projectone.pages.DragAndDropProgressBarsPage;

import cucumber.api.java.en.And;

public class TestProgressBarsPage {

    DragAndDropProgressBarsPage dragAndDropProgressBarsPage;

    @And("^I set first slider as (.*)$")
    public void i_set_default_value(int value) throws InterruptedException {
        dragAndDropProgressBarsPage = new DragAndDropProgressBarsPage();
        dragAndDropProgressBarsPage.moveFirstSlider(value);
    }
}
