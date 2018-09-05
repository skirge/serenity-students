package starter;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class SerenityJunitTestSuite {

    @Managed
    WebDriver driver;

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"admin","password", "Przejdź na listę studentów"},
                {"incorrect",  "incorrect", "Wystąpił niespodziewany błąd!"}
        });
    }

    private String username;
    private String password;
    private String message;

    @Steps
    LoginStepDefinitions loginSteps;

    public SerenityJunitTestSuite(String username, String password, String message) {
        this.username = username;
        this.password = password;
        this.message = message;
    }

    @After
    public void logout() {
        loginSteps.logout_user();
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
