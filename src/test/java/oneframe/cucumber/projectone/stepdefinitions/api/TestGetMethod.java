package oneframe.cucumber.projectone.stepdefinitions.api;

import org.json.JSONException;
import org.json.JSONObject;

import com.oneframe.cucumber.oneframeutils.LogPrinter;
import com.oneframe.cucumber.projectone.beans.ResponseBean;
import com.oneframe.cucumber.projectone.webservicehelper.GetHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TestGetMethod {

    @Given("^I hit the GET method to get list of users$")
    public void i_hit_the_get_method_to_get_list_ofUser() throws JSONException {
        LogPrinter.printLog("List of Users are " + GetHelper.getListUsers());
    }

    @Given("^I hit the GET method to get single users$")
    public void i_hit_the_get_method_to_get_single_users() throws JSONException {
        LogPrinter.printLog("Single User Details are " + GetHelper.getSingleUser());
    }

    @Then("^I verify the list of user details are correct$")
    public void i_verify_the_list_of_user_details_are_correct() throws JSONException {
        JSONObject response = ResponseBean.getResponse();
        String userCount = response.getString("total");
        System.out.println("UserCount is " + userCount);

    }

    @Then("^I verify the single users details are correct$")
    public void i_verify_the_single_users_details_are_correct() throws JSONException {
        JSONObject response = ResponseBean.getResponse();
        String id = response.getJSONObject("data").getString("id");
        System.out.println("id is " + id);
    }

}
