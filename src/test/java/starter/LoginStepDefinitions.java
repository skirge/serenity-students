package starter;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.PageObject;
import starter.pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions {

    LoginPage loginPage;

    private String correctUsername = "admin";
    private String correctPassword = "password";

    @Given("^login page is open$")
    public void login_page_is_open() throws Exception {
        loginPage.open();
    }

    @When("^user provides correct credentials$")
    public void user_provides_correct_credentials() throws Exception {
        loginPage.fillCredentials(correctUsername, correctPassword);
    }

    @When("^triggers login action$")
    public void triggers_login_action() throws Exception {
        loginPage.triggerLogin();
    }

    @Then("^page visible only to logged in users is shown$")
    public void page_visible_only_to_logged_in_users_is_shown() throws Exception {
        assertTrue(loginPage.isLinkVisible());
    }

    @When("^user enters (\\w+) and (\\w+)")
    public void user_enters_login_and_password(String username, String password) throws Exception {
        loginPage.fillCredentials(username, password);
    }

    @Then("^Message (\\w+) is visible$")
    public void message_is_visible(String message) throws Exception {
        assertTrue(loginPage.isMessageVisible(message));
    }

    @And("^User is logged out$")
    public void logout_user() {
        loginPage.triggerLogout();
    }
}
