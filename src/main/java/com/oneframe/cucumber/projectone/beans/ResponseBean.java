package com.oneframe.cucumber.projectone.beans;

import org.json.JSONObject;

public class ResponseBean {
  private static ResponseBean responseBeans;
  private JSONObject response;
  private int statusCode;

  /**
   * Private no argument constructor for FilesBeans restricting instance creation.
   */
  private ResponseBean() {

  }

  /**
   * Initialize the Bean static singleton instance.
   */
  private static void initFileBean() {
    if (responseBeans == null) {
      responseBeans = new ResponseBean();
    }
  }

  /**
   * Set Response.
   *
   * @param response - response after hitting the API.
   */
  public static void setResponse(JSONObject response) {
    if (responseBeans == null) {
      initFileBean();
    }
    responseBeans.response = response;
  }

  /**
   * Get the response.
   *
   * @return - response after hitting the API.
   */
  public static JSONObject getResponse() {
    if (responseBeans == null) {
      initFileBean();
    }
    return responseBeans.response;
  }

  /**
   * Set status code.
   *
   * @param statusCode - status code of response.
   */
  public static void setStatusCode(int statusCode) {
    if (responseBeans == null) {
      initFileBean();
    }
    responseBeans.statusCode = statusCode;
  }

  /**
   * Get status code of response.
   *
   * @return - Status code of response.
   */
  public static int getStatusCode() {
    if (responseBeans == null) {
      initFileBean();
    }
    return responseBeans.statusCode;
  }
}
