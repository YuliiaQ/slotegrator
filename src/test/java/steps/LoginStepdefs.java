package steps;

import enums.EnumNavbarItems;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginStepdefs {

    private static final LoginPage loginPage = new LoginPage();
    private static final DashboardPage dashboardPage = new DashboardPage();

    @When("user enters valid data to login fields")
    public void userEntersValidDataToLoginFields() {
        loginPage.loginIntoDashboard();
    }

    @Then("{} is opened")
    public void theDashboardIsOpened(EnumNavbarItems enumNavbarItems) {
        Assertions.assertThat(dashboardPage.isTabActiveByName(enumNavbarItems)).isEqualTo(true);
    }

}
