package oneframe.cucumber.stepdefinitions.hooks;

import java.io.IOException;
import java.net.UnknownHostException;

import com.oneframe.cucumber.oneframebase.utils.LogPrinter;
import com.oneframe.cucumber.oneframebase.utils.MachineUtils;
import com.oneframe.cucumber.oneframebase.utils.Utilities;
import com.oneframe.cucumber.oneframebase.utils.WebDriverFactory;
import com.oneframe.cucumber.oneframebase.utils.database.MySqlBeans;
import com.oneframe.cucumber.oneframebase.utils.database.MySqlDbUtils;
import com.oneframe.cucumber.oneframebase.utils.timeutils.TimeDurationCalculator;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * {@link CucumberSceanrioHook} class will re-initailize the DatabaseBean before
 * and after each scenario to resolve the conflicts if occurred during the
 * scenarios execution.
 *
 */
public class CucumberSceanrioHook {

  private TimeDurationCalculator timeDurationCalculator = new TimeDurationCalculator();

  @Before
    public void beforeSceanrio(Scenario scenario) throws UnknownHostException {
      LogPrinter.printLog("Execution Started---");
      LogPrinter.printLog("Application Name: " + Utilities.getEnvironmentProperties("ApplicationName"));
      LogPrinter.printLog("Scenario Name: " + scenario.getName());
      LogPrinter.printLog("IP Address of the Machine: " + MachineUtils.getMachineIpAaddress());
      timeDurationCalculator.start();
      //setDataBaseDetails(scenario);
    }

    @After
    public void afterSceanrio(Scenario scenario) throws IOException {
      timeDurationCalculator.stop();
      LogPrinter.printLog("Execution Status: " + scenario.getStatus());
      MySqlBeans.setExecutionStatus(scenario.getStatus());
      WebDriverFactory.closeWindow();
      timeDurationCalculator.calculate();
      MySqlBeans.setExecutionTime(timeDurationCalculator.getTotalSecondsElapsed());
      //insertAutomationExecutionData();
    }

    /**
     * This method is written to set database details required to insert data into the database
     * table.
     *
     * @param scenario - Scenario
     * @throws UnknownHostException - if in case of finding any Unknown Host Exceptions.
     */
    public static void setDataBaseDetails(Scenario scenario) throws UnknownHostException {
      MySqlBeans.setMySqlDbHostName(Utilities.getEnvironmentProperties("MySqlDBHost"));
      MySqlBeans.setMysqlDbPortNumber(Utilities.getEnvironmentProperties("MySqlDBPort"));
      MySqlBeans.setMysqlDbName(Utilities.getEnvironmentProperties("MySqlDBName"));
      MySqlBeans.setMysqlDbUserName(Utilities.getEnvironmentProperties("MySqlDBUsername"));
      MySqlBeans.setMysqlDbUserPassword(Utilities.getEnvironmentProperties("MySqlDBPassword"));
      MySqlBeans.setMysqlDbTableName(Utilities.getEnvironmentProperties("MySqlDBTable"));
      MySqlBeans.setApplicationName(Utilities.getEnvironmentProperties("ApplicationName"));
      MySqlBeans.setTestCaseName(scenario.getName());
      MySqlBeans.setMachineIpAddress(MachineUtils.getMachineIpAaddress());
    }

    /**
     * Insert automation execution data into the database into mysql database.
     */
    public static void insertAutomationExecutionData() {
      MySqlDbUtils.insertAutomationExecutionData(MySqlBeans.getApplicationName(),
          MySqlBeans.getTestCaseName(), MySqlBeans.getExecutionTime(),
          MySqlBeans.getExecutionStatus(), MySqlBeans.getMachineIp());
    }
}