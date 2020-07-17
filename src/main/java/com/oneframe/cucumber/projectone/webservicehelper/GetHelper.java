package com.oneframe.cucumber.projectone.webservicehelper;

import static io.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;

import com.oneframe.cucumber.oneframebase.constants.JSONConstants;
import com.oneframe.cucumber.oneframebase.utils.Utilities;
import com.oneframe.cucumber.projectone.beans.ResponseBean;

import io.restassured.response.Response;

public class GetHelper {
    private static Response response = null;
    private static String errorMessage = null;

    /**
     * Get details of all the users.
     *
     * @return - Details of all users.
     * @throws JSONException
     *             - if in case of json exceptions.
     * @author sudheer.singh
     */
    public static JSONObject getListUsers() throws JSONException {
        response = given().when().get(Utilities.getEnvironmentProperties("GetListOfUsers"));
        if (response.statusCode() != JSONConstants.OK_STATUS_CODE) {
            errorMessage = response.then().extract().asString();
            throw new JSONException("Service to get access token is not working " + errorMessage);
        }
        ResponseBean.setResponse(new JSONObject(response.asString()));
        return new JSONObject(response.asString());
    }

    /**
     * Get details of single user.
     *
     * @return - details of single user.
     * @throws JSONException
     *             - if in case of json exceptions.
     * @author sudheer.singh
     */
    public static JSONObject getSingleUser() throws JSONException {
        response = given().when().get(Utilities.getEnvironmentProperties("GetDetailsOfSingleUser"));
        if (response.statusCode() != JSONConstants.OK_STATUS_CODE) {
            errorMessage = response.then().extract().asString();
            throw new JSONException("Service to get access token is not working " + errorMessage);
        }
        ResponseBean.setResponse(new JSONObject(response.asString()));
        return new JSONObject(response.asString());
    }
}
