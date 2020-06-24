package com.oneframe.cucumber.projectone.webservicehelper;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.oneframe.cucumber.oneframe.utils.FileUtil;
import com.oneframe.cucumber.oneframe.utils.LogPrinter;
import com.oneframe.cucumber.oneframe.utils.Utilities;
import com.oneframe.cucumber.projectone.beans.ResponseBean;
import com.oneframe.cucumber.projectone.constants.JSONConstants;

import io.restassured.response.Response;

public class PostHelper {

    private static Response response = null;
    private static String errorMessage = null;

    /**
     * Create an user.
     *
     * @throws IOException
     *             - if in case of io exception.
     * @throws JSONException
     *             - if in case of json exception.
     * @author sudheer.singh
     */
    public static void createAnUser() throws IOException, JSONException {
        JSONObject payload = FileUtil.readJSONFile("projectOne/createUser.json");
        payload.put("name", "sample");
        payload.put("job", "freeLancer");
        response = given().when().body(payload.toString()).post(Utilities.getEnvironmentProperties("CreateUser"));
        if (response.statusCode() != JSONConstants.OK_STATUS_CREATED) {
            errorMessage = response.then().extract().asString();
            throw new JSONException("User is not created" + errorMessage);
        }
        LogPrinter.printLog("User is created");
        ResponseBean.setStatusCode(response.statusCode());
    }
}
