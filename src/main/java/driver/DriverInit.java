package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertyLoader;

import java.util.concurrent.TimeUnit;

import static utils.Constants.CONFIGURATION_FILEPATH;

@Getter
public class DriverInit {

    @Getter
    private WebDriver driver;

    public WebDriver setDriver() {
        PropertyLoader.readProperties(CONFIGURATION_FILEPATH);
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(PropertyLoader.getPropertyValue(CONFIGURATION_FILEPATH, "url"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;

    }
}
