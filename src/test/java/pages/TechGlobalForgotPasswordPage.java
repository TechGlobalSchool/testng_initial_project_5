package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalForgotPasswordPage extends TechGlobalBasePage {
    public TechGlobalForgotPasswordPage() {
        super();
    }

    @FindBy(id = "sub_heading")
    public WebElement subHeading;

    @FindBy(css = "label[for='email']")
    public WebElement passwordRequestMessage;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "confirmation_message")
    public WebElement confirmationMessage;
}
