package steps;

import enums.EnumDashboardBoxes;
import enums.EnumTableRowsName;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.DashboardPage;
import pages.PlayerManagementPage;

public class DashboardStepdefs {

    private static final DashboardPage dashboardPage = new DashboardPage();
    private static final PlayerManagementPage playerManagementPage = new PlayerManagementPage();

    @When("user clicks {} box")
    public void iClickBox(EnumDashboardBoxes enumDashboardBoxes) {
        dashboardPage.clickOnPanelBox(enumDashboardBoxes);
    }

    @And("user checks that the table is present")
    public void userChecksThatTheTableIsPresent() {
        Assertions.assertThat(playerManagementPage.checkThatTableExists()).isEqualTo(true);
    }

    @And("user clicks on table row name {} to sort it")
    public void userClicksOnTableRowNameToSortIt(EnumTableRowsName enumTableRowsName) {
        playerManagementPage.clickOnTableRowNameToSortTable(enumTableRowsName);
    }

    @Then("user sees the sorted table")
    public void userSeesTheSortedTable() {
        Assertions.assertThat(playerManagementPage.getListOfColumnItems()).isEqualTo(true);
    }
}
