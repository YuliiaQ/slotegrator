package pages;

import enums.EnumLoginPageFields;
import utils.PropertyLoader;

import static utils.Constants.CONFIGURATION_FILEPATH;

public class LoginPage extends CommonMethods {

    private static final String XPATH_FOR_LOGIN_DATA_FIELD = "//div[@class='input-group input-group-lg']//input[@id='%s']";
    private static final String XPATH_FOR_SIGN_IN_BUTTON = "//input[@class='btn btn-primary btn-lg btn-block']";

    public void loginIntoDashboard() {
        findElementByXPath(String.format(XPATH_FOR_LOGIN_DATA_FIELD, EnumLoginPageFields.LOGIN)).sendKeys(PropertyLoader.getPropertyValue(CONFIGURATION_FILEPATH, "username"));
        findElementByXPath(String.format(XPATH_FOR_LOGIN_DATA_FIELD, EnumLoginPageFields.PASSWORD)).sendKeys(PropertyLoader.getPropertyValue(CONFIGURATION_FILEPATH, "password"));
        findElementByXPath(XPATH_FOR_SIGN_IN_BUTTON).click();
    }

}
