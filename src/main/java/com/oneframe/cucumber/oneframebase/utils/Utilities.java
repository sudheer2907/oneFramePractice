package com.oneframe.cucumber.oneframebase.utils;

import java.util.ResourceBundle;

public class Utilities {
    private static final ResourceBundle rb1;
    private static ResourceBundle rb2;

    static {
        rb1 = ResourceBundle.getBundle("properties/config");
    }

    /**
     * get config properties.
     *
     * @param keyString
     *            - key string whose value tp be fetched.
     * @return - key value
     * @author sudheer.singh
     */
    public static String getConfigProperties(String keyString) {
        return rb1.getString(keyString);
    }

    /**
     * get environment config properties.
     *
     * @param keyString
     *            - key string whose value tp be fetched.
     * @return - key value
     * @author sudheer.singh
     */
    public static String getEnvironmentProperties(String keyString) {
        if (rb2 == null) {
            String environmentStr = getConfigProperties("Environment");
            LogPrinter.printLog("Execution Environment: " + environmentStr);
            rb2 = ResourceBundle.getBundle("properties/" + environmentStr + "config");
        }
        return rb2.getString(keyString);
    }
}