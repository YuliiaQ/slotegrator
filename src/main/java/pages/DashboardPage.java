package pages;

import enums.EnumDashboardBoxes;
import enums.EnumNavbarItems;

public class DashboardPage extends CommonMethods {

    private static final String XPATH_FOR_NAVBAR_DROPDOWN_FIELDS = "//ul[@id='nav']//li[@class='active']//a//i//following::span[text()='%s']";
    private static final String XPATH_FOR_PANEL_BOXES_ON_DASHBOARD = "//a[@href='%s']//div[@class='panel mini-box']";

    public boolean isTabActiveByName(EnumNavbarItems enumNavbarItems) {
        return isElementPresent(String.format(XPATH_FOR_NAVBAR_DROPDOWN_FIELDS, enumNavbarItems.toString()));
    }

    public void clickOnPanelBox(EnumDashboardBoxes enumDashboardBoxes) {
        waitForClickabilityOfElement(String.format(XPATH_FOR_PANEL_BOXES_ON_DASHBOARD, enumDashboardBoxes.toString()));
        findElementByXPath(String.format(XPATH_FOR_PANEL_BOXES_ON_DASHBOARD, enumDashboardBoxes)).click();
    }
}
