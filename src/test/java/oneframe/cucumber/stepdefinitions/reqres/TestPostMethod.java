package oneframe.cucumber.stepdefinitions.reqres;

import java.io.IOException;

import org.json.JSONException;
import org.junit.Assert;

import com.oneframe.cucumber.oneframebase.constants.JSONConstants;
import com.oneframe.cucumber.oneframebase.utils.LogPrinter;
import com.oneframe.cucumber.projectone.beans.ResponseBean;
import com.oneframe.cucumber.projectone.webservicehelper.PostHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TestPostMethod {

    @Given("^I hit the POST method to create an user$")
    public void i_hit_the_post_method_to_create_an_user() throws IOException, JSONException {
        PostHelper.createAnUser();
    }

    @Then("^I verify the user is created$")
    public void i_verify_the_user_is_created() {
        if (ResponseBean.getStatusCode() != JSONConstants.OK_STATUS_CREATED) {
            Assert.fail("User is not created");
        }
        LogPrinter.printLog("It is verified that user has been created");
    }
}
