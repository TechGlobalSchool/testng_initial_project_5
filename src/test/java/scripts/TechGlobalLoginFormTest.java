package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.ConfigProperties;

public class TechGlobalLoginFormTest extends TechGlobalBase {
    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();

        techGlobalFrontendTestingHomePage.headerDropdown.click();
        techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
    }

    @Test(priority = 1, description = "Validate Login Form card")
    public void validateLoginFormCard() {
        // Validate heading visibility and text
        Assert.assertTrue(techGlobalLoginFormPage.mainHeading.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.mainHeading.getText(), "Login Form");

        // Validate username label visibility and text
        Assert.assertTrue(techGlobalLoginFormPage.usernameLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.usernameLabel.getText(), "Please enter your username");
        Assert.assertTrue(techGlobalLoginFormPage.usernameInputField.isDisplayed());

        // Validate password label visibility and text
        Assert.assertTrue(techGlobalLoginFormPage.passwordLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.passwordLabel.getText(), "Please enter your password");
        Assert.assertTrue(techGlobalLoginFormPage.passwordInputField.isDisplayed());

        // Validate login button visibility and text
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.loginButton.getText(), "LOGIN");

        // Validate forgot password link visibility and text
        Assert.assertTrue(techGlobalLoginFormPage.forgotPasswordLink.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.forgotPasswordLink.getText(), "Forgot Password?");
    }

    /*
    Test Case 2: Validate TechGlobal Login Form card valid login
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “You are logged in” message
    And user should see “LOGOUT” button
     */
    @Test(priority = 2, description = "Validate TechGlobal Login Form card valid login")
    public void validateLoginFormWithValidCredentials() {
        techGlobalLoginFormPage.login(
                ConfigProperties.getProperty("testUsername"),
                ConfigProperties.getProperty("testPassword"));

        Assert.assertEquals(techGlobalLoginFormPage.successfulMessage.getText(), "You are logged in");
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.logoutButton.getText(), "LOGOUT");
    }

    /*
    Test Case 3: Validate TechGlobal Login Form card valid login and then
    logout
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    And user clicks on “LOGOUT” button
    Then user should be navigated back to Login Form
     */
    @Test(priority = 3, description = "Validate TechGlobal Login Form card valid login and then logout")
    public void validateLoginLogout() {
        techGlobalLoginFormPage.login(
                ConfigProperties.getProperty("testUsername"),
                ConfigProperties.getProperty("testPassword"));
        techGlobalLoginFormPage.logout();

        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
    }

    /*
    Test Case 6: Validate TechGlobal Login Form card invalid login with
    wrong username
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
     */
    @Test(priority = 4, description = "Validate TechGlobal Login Form card invalid login with wrong username")
    public void validateLoginFormWithWrongUsername() {
        techGlobalLoginFormPage.login("john", ConfigProperties.getProperty("testPassword"));

        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(),
                "Invalid Username entered!");
    }

    /*
    Test Case 7: Validate TechGlobal Login Form card invalid login with
    wrong password
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Password entered!” message
     */
    @Test(priority = 5, description = "Validate TechGlobal Login Form card invalid login with wrong password")
    public void validateLoginFormWithWrongPassword() {
        techGlobalLoginFormPage.login(ConfigProperties.getProperty("testUsername"), "1234");

        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(),
                "Invalid Password entered!");
    }

    /*
    Test Case 8: Validate TechGlobal Login Form card invalid login with
    both wrong credentials
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
     */
    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with both wrong credentials")
    public void validateLoginFormWithInvalidCredentials() {
        techGlobalLoginFormPage.login("john", "1234");

        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), "Invalid Username entered!");
    }
}
