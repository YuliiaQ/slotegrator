package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonMethods {

    @Getter
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private final int durationInSeconds = 30;
    private final WebDriverWait wait = new WebDriverWait(getDriverThreadLocal(), durationInSeconds);

    public static WebDriver getDriverThreadLocal() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriverThreadLocal(WebDriver webDriver) {
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public WebElement waitForVisibilityOfElement(String locator) {
        return wait.
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public WebElement waitForClickabilityOfElement(String locator) {
        return wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public WebElement findElementByXPath(String xpath) {
        return waitForVisibilityOfElement(xpath);
    }

    public List<WebElement> findAllElementsByXPath(String xpath) {
        return getDriverThreadLocal().findElements(By.xpath(xpath));
    }

    public void waitUntilStalenessOf(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }


    public Boolean isElementPresent(String xpath) {
        return !findAllElementsByXPath(xpath).isEmpty();
    }
}
