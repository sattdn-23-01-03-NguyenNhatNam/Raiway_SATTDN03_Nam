package railway;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.GeneralPage;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends BaseTest {
    private HomePage homePage = new HomePage();
    private LoginPage logInPage = new LoginPage();
    private GeneralPage generalPage = new GeneralPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test(description = "User can login Railway with valid username and password")
    public void TC01() {
        homePage.open();
        homePage.clickOnTabLogin();
        logInPage.login(Constant.Username, Constant.Password);
        String actual = logInPage.showMessageWelcome();
        String expected = "Welcome " + Constant.Username;

        Assert.assertEquals(actual, expected);

        homePage.clickOnTabLogout();
    }

    @Test(description = "User can't login with blank \"Username\" textbox")
    public void TC02() {
        homePage.open();
        homePage.clickOnTabLogin();
        logInPage.login("", Constant.Password);

        Assert.assertEquals(logInPage.getTextMessageErrorLogin(), "There was a problem with your login and/or errors exist in your form.", "The error doesn't display properly");
        Assert.assertEquals(logInPage.getTextMessageErrorValidField(), "You must specify a username.", "The error doesn't display properly");
    }

    @Test(description = "User cannot log into Railway with invalid password")
    public void TC03() {
        homePage.open();
        homePage.clickOnTabLogin();
        logInPage.login(Constant.Username, "1231223123");

        Assert.assertEquals(logInPage.getTextMessageErrorLogin(), "There was a problem with your login and/or errors exist in your form.", "The error doesn't display properly");
    }

    @Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
    public void TC04() {
        homePage.open();
        homePage.clickOnTabBookTicket();
        String actualURL = Constant.WEBDRIVER.getCurrentUrl();
        String expectedURL = "http://www.railwayb2.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";

        Assert.assertEquals(actualURL, expectedURL, "Something wrong with matching Url");
    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        homePage.open();
        homePage.clickOnTabLogin();
        String password = "123123123";
        logInPage.loginWithInvalidAccountSeveralTimes(4, Constant.Username, password);
        String actual = logInPage.getTextMessageErrorLogin();
        String expected = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actual, expected, "The error message doesn't display properly");
    }

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        homePage.open();
        homePage.clickOnTabLogin();
        logInPage.login(Constant.Username, Constant.Password);

        Assert.assertTrue(generalPage.getChangePassword().isDisplayed());
        Assert.assertTrue(generalPage.getTabLogout().isDisplayed());
        Assert.assertTrue(generalPage.getTabMyTicket().isDisplayed());

        homePage.clickOnTabChangPassword();

        Assert.assertTrue(changePasswordPage.getLblTitleChangePassword().isDisplayed());

        homePage.clickOnTabLogout();
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08() {
        homePage.open();
        homePage.clickOnTabLogin();
        logInPage.login("namdayne@gmail.com", "123123123");

        Assert.assertEquals(logInPage.getTextMessageErrorLogin(), "Invalid username or password. Please try again.", "The error message doesn't display properly");
    }
}
