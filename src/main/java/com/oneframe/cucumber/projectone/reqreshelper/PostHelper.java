package com.oneframe.cucumber.projectone.reqreshelper;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.oneframe.cucumber.oneframebase.constants.JsonConstants;
import com.oneframe.cucumber.oneframebase.utils.LogPrinter;
import com.oneframe.cucumber.oneframebase.utils.Utilities;
import com.oneframe.cucumber.oneframebase.utils.fileutils.FileUtil;
import com.oneframe.cucumber.projectone.beans.ResponseBean;

import io.restassured.response.Response;

public class PostHelper {

  private PostHelper() {
    LogPrinter.printLog("Can not be intantiated");
  }

  /**
   * Create an user.
   *
   * @throws IOException - if in case of io exception.
   * @throws JSONException - if in case of json exception.
   * @author sudheer.singh
   */
  public static void createAnUser() throws IOException, JSONException {
    JSONObject payload = FileUtil.readJsonFile("projectOne/createUser.json");
    payload.put("name", "sample");
    payload.put("job", "freeLancer");
    Response response = given().when().body(payload.toString())
        .post(Utilities.getEnvironmentProperties("CreateUser"));
    if (response.statusCode() != JsonConstants.OK_STATUS_CREATED) {
      String errorMessage = response.then().extract().asString();
      throw new JSONException("User is not created" + errorMessage);
    }
    LogPrinter.printLog("User is created");
    ResponseBean.setStatusCode(response.statusCode());
  }
}
