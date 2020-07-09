package com.oneframe.cucumber.oneframe.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestException;

public abstract class WebDriverFactory {
    private static WebDriver driver;
    static String path;

    /**
     * Launch application and navigate to the base url to start the execution.
     *
     * @author sudheer.singh
     */
    public static void openApplication() {
        String bwoserNameString = Utilities.getEnvironmentProperties("browser");
        path = System.getProperty("user.dir");
        switch (bwoserNameString.toUpperCase()) {
        case "CHROME":
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
            setDriver(new ChromeDriver());
            break;
        case "FIREFOX":
            setDriver(new FirefoxDriver());
            break;
        default:
            Assert.fail("Wrong browser Name provided.");
        }
        getDriver().manage().window().maximize();
        getDriver().get(Utilities.getEnvironmentProperties("baseUrl"));
    }

    /**
     * Wait for Page to Load.
     *
     * @param timeout
     *            - page load time out.
     * @author sudheer.singh
     */
    public static void waitForPageToLoad(int timeout) {
        new WebDriverWait(driver, timeout).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver input) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        });
    }

    /**
     * get web driver instance.
     *
     * @return - web driver.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Set web driver.
     *
     * @param driver
     *            - web driver.
     */
    public static void setDriver(WebDriver driver) {
        WebDriverFactory.driver = driver;
    }

    /**
     * Close window.
     */
    public static void closeWindow() {
        getDriver().close();
        getDriver().quit();
    }

    /**
     * Highlight web element while ececution.
     *
     * @param element
     *            - web element to be highlighted
     * @throws InterruptedException
     *             - if in case of interrupted exception.
     * @author sudheer.singh
     */
    public static void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid yellow;');", element);
        TimeUnit.SECONDS.sleep(1);
        js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }

    /**
     * Take screenshots before test case failed.
     *
     * @param driver
     *            - web driver.
     * @param screenshotname
     *            - name of screenshot.
     * @author sudheer.singh
     */
    public static void captureScreenShot(WebDriver driver, String screenshotname) {
        String path = System.getProperty("user.dir");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(path + "/target/test-report/sceenshots/" + screenshotname + ".jpeg"));
        } catch (IOException e) {
            LogPrinter.printLog("Unable to take screenshots");
            LogPrinter.printLog(e.getMessage());
        }
    }

    /**
     * Click on the web element.
     *
     * @param element
     *            - web element.
     * @author sudheer.singh
     */
    public static void clickWebElement(WebElement element) {
        if (!element.isEnabled()) {
            throw new TestException(element.getText() + " is not clickable");
        }
        try {
            highlight(element);
            element.click();
        } catch (Exception e) {
            captureScreenShot(WebDriverFactory.getDriver(), element.getText());
        }
    }

    /**
     * enter text into text field.
     *
     * @param element
     *            - web element.
     * @param text
     *            - text to be entered into text box.
     * @author sudheer.singh
     */
    public static void sendKeys(WebElement element, String text) {
        if (!element.isEnabled()) {
            throw new TestException("WebElement " + element + " is not editabe as It is disabled");
        }
        try {
            highlight(element);
            element.sendKeys(text);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Select element or drop-down value from a drop-down.
     *
     * @param element
     *            - web element.
     * @param dropDownValue
     *            - drop value to be selected.
     * @author sudheer.singh
     */
    public static void selectElementByvalue(WebElement element, String dropDownValue) {
        if (!element.isEnabled()) {
            throw new TestException("WebElement " + element + " is not editabe as It is disabled");
        }
        try {
            highlight(element);
            Select sel = new Select(element);
            sel.selectByValue(dropDownValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for an element to be visible.
     *
     * @param element
     *            - web element.
     * @param timeOut
     *            - waiting time period.
     * @author sudheer.singh
     */
    public static void waitForAnElementToBeVisible(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
