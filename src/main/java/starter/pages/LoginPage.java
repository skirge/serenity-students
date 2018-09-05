package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost:3000/")
public class LoginPage extends PageObject {

    @FindBy(name = "login")
    WebElementFacade userNameField;

    @FindBy(name = "password")
    WebElementFacade passwordField;

    @FindBy(name = "submit")
    WebElementFacade loginButton;

    @FindBy(xpath = "//a[@href=\"/list\"]")
    WebElementFacade link;

    public void fillCredentials(String username, String password) {
        userNameField.type(username);
        passwordField.type(password);
    }

    public void triggerLogin() {
        loginButton.click();
    }

    public boolean isLinkVisible() {
        return link.isVisible();
    }

    public boolean isMessageVisible(String message) {
        return findBy("//*[text()='" + message + "']").isVisible();
    }

    public void triggerLogout() {
        findBy("//a[text()='Wyloguj']").click();
    }
}
