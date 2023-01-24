package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalForgotPasswordPage;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.ConfigProperties;

public class TechGlobalForgotPasswordTest extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalForgotPasswordPage = new TechGlobalForgotPasswordPage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();

        techGlobalFrontendTestingHomePage.getFrontendPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
        techGlobalLoginFormPage.forgotPasswordLink.click();
    }

    /*
    Test Case 4: Validate TechGlobal Login Form card Forgot Password?
    Link and Reset Password page
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    Then user should see “Reset Password” heading1
    And user should see “Enter your email address and we'll send you a link to reset
    your password.” message
    And user should see email input box
    And user should see “SUBMIT” button
     */
    @Test(priority = 1, description = "Validate TechGlobal Login Form card Forgot Password?")
    public void validateForgotPasswordForm() {
        // user should see “Reset Password” heading1
        Assert.assertTrue(techGlobalForgotPasswordPage.subHeading.isDisplayed());
        Assert.assertEquals(techGlobalForgotPasswordPage.subHeading.getText(), "Reset Password");

        // user should see “Enter your email address and we'll send you a link to reset
        // your password.” message
        Assert.assertTrue(techGlobalForgotPasswordPage.passwordRequestMessage.isDisplayed());
        Assert.assertEquals(techGlobalForgotPasswordPage.passwordRequestMessage.getText(),
                "Enter your email address and we'll send you a link to reset your password.");

        // user should see email input box
        Assert.assertTrue(techGlobalForgotPasswordPage.emailInputBox.isDisplayed());

        // user should see “SUBMIT” button
        Assert.assertTrue(techGlobalForgotPasswordPage.submitButton.isDisplayed());
        Assert.assertEquals(techGlobalForgotPasswordPage.submitButton.getText(), "SUBMIT");
    }

    /*
    Test Case 5: Validate TechGlobal Login Form card Reset Password link
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    When user enters a valid email to email input box
    And user clicks on “SUBMIT” button
    Then user should see “A link to reset your password has been sent to your email
    address.” message
     */
    @Test(priority = 2, description = "Validate TechGlobal Login Form card Reset Password link")
    public void validateSuccessfulEmailSubmision() {
        techGlobalForgotPasswordPage.emailInputBox.sendKeys(ConfigProperties.getProperty("testEmail"));
        techGlobalForgotPasswordPage.submitButton.click();

        Assert.assertTrue(techGlobalForgotPasswordPage.confirmationMessage.isDisplayed());
        Assert.assertEquals(techGlobalForgotPasswordPage.confirmationMessage.getText(),
                "A link to reset your password has been sent to your email address.");
    }

}
