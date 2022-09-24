package pages;

import enums.EnumTableRowsName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerManagementPage extends CommonMethods {

    private static final String XPATH_FOR_TABLE = "//table[@class='table table-hover table-striped table-bordered table-condensed']";
    private static final String XPATH_FOR_NAME_OF_ROW = "//thead//tr//th//a[translate(normalize-space(text()), 'abcdefghijklmnopqrstuvwxyz', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ') = '%s']";
    private static final String XPATH_FOR_ITEMS_IN_ROW = "//tr//td//a[not(@class)]";

    public boolean checkThatTableExists() {
        return isElementPresent(XPATH_FOR_TABLE);
    }

    public void clickOnTableRowNameToSortTable(EnumTableRowsName enumTableRowsName) {
        String locator = String.format(XPATH_FOR_NAME_OF_ROW, enumTableRowsName.toString().toUpperCase());
        WebElement firstRowInColumnUsername = findElementByXPath(XPATH_FOR_ITEMS_IN_ROW);
        findElementByXPath(locator).click();
        waitUntilStalenessOf(firstRowInColumnUsername);
    }

    public boolean getListOfColumnItems() {
        List<String> columnItems = new ArrayList<>();

        List<WebElement> columnWithText = getDriverThreadLocal().findElements(By.xpath(XPATH_FOR_ITEMS_IN_ROW));

        for (WebElement element : columnWithText) {
            columnItems.add(element.getText());
        }

        List<String> sortedValues = new ArrayList<>(columnItems);
        Collections.sort(sortedValues);
        System.out.println("Sorted values: " + sortedValues);

        int sizeOfList = columnItems.size();
        boolean check = true;
        for (int i = 0; i < sizeOfList; i++) {
            check = columnItems.get(i).equals(sortedValues.get(i));
            if (!check) break;
        }

        return check;
    }

}
