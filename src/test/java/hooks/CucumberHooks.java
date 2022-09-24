package hooks;

import driver.DriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.CommonMethods;

@Getter
public class CucumberHooks {

    private WebDriver driver;

    @Before("@ui")
    public void getDriver() {
        driver = new DriverInit().setDriver();
        CommonMethods.setDriverThreadLocal(driver);
    }

    @After("@ui")
    public void quitDriver(Scenario scenario) {
        System.out.println("Ending Test: " + scenario.getName());
        System.out.println(scenario.getStatus());
        if (driver != null)
            CommonMethods.getDriverThreadLocal().quit();
    }
}
