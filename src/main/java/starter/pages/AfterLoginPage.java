package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class AfterLoginPage extends PageObject{

    @FindBy(xpath = "//a[@href=\"/list\"]")
    WebElementFacade link;


}
