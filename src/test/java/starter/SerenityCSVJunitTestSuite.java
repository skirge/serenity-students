package starter;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="testdata/logins.csv")
public class SerenityCSVJunitTestSuite {

    @Managed
    WebDriver driver;

    private String username;
    private String password;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Qualifier
    public String qualifier() {
        return username + ":" + password + "=>" + message;
    }

    @Steps
    LoginStepDefinitions loginSteps;


    @After
    public void logout() {
        loginSteps.logout_user();
    }

    public SerenityCSVJunitTestSuite() {
    }

    @Test
    public void testLoginWithDifferentCredentials() throws Exception {
        // GIVEN
        loginSteps.login_page_is_open();

        // WHEN
        loginSteps.user_enters_login_and_password(username, password);
        loginSteps.triggers_login_action();

        // THEN
        loginSteps.message_is_visible(message);

    }
}
