package railway;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.HomePage;
import page.LoginPage;
import page.RegisterPage;
import utils.Utilities;

public class RegisterTest extends BaseTest {
    private RegisterPage registerPage = new RegisterPage();
    private LoginPage loginPage = new LoginPage();
    private HomePage homePage = new HomePage();
    private SoftAssert softAssert = new SoftAssert();

    @Test(description = "User can login Railway with registered username and password")
    public void TC00() {
        String email = "nhatnam" + Utilities.randomNumber(20, 100) + "@gmail.com";
        String password = "12345678";
        String confirmPassword = password;
        String passportNumber = "123123123";
        homePage.open();
        homePage.clickOnTabRegister();
        registerPage.register(email, password, confirmPassword, passportNumber);
        String actualMsg = registerPage.getTextMsgSuccess();

        Assert.assertEquals(actualMsg, "Thank you for registering your account", "Register failure, Account already exists");

        homePage.clickOnTabLogin();
        loginPage.login(email, password);
    }

    @Test(description = "User can create new account")
    public void TC07() {
        homePage.open();
        homePage.clickOnTabRegister();
        registerPage.register("nam" + Utilities.randomNumber(10, 1000) + "@gmail.com", "123456789", "123456789", "123123123");
        String actualMsg = registerPage.getTextMsgSuccess();

        Assert.assertEquals(actualMsg, "Thank you for registering your account", "Register failure, Account already exists");
    }

    @Test(description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
    public void TC10() {
        homePage.open();
        homePage.clickOnTabRegister();
        String password = "namquadeptrai";
        String confirmPassword = "namratdeptrai";
        registerPage.register("nam6@gmail.com", password, confirmPassword, "123123123");

        softAssert.assertEquals(registerPage.getTextMsgErrorRegister(), "There're errors in the form. Please correct the errors and try again.", "The error message doesn't display properly");
        softAssert.assertEquals(registerPage.getTextMsgErrorConfirmPassword(), "The two passwords do not match", "The error message doesn't display properly");
        softAssert.assertAll();
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        homePage.open();
        homePage.clickOnTabRegister();
        registerPage.register("nam7@gmail.com", "", "123456789", "");

        softAssert.assertEquals(registerPage.getTextMsgErrorRegister(), "There're errors in the form. Please correct the errors and try again.", "The error message doesn't display properly");
        softAssert.assertEquals(registerPage.getTextMsgErrorInValidPassword(), "Invalid password length.", "The error message doesn't display properly");
        softAssert.assertEquals(registerPage.getTextMsgErrorConfirmPassword(), "The two passwords do not match", "The error message doesn't display properly");
        softAssert.assertEquals(registerPage.getTextMsgErrorInValidPID(), "Invalid ID length.", "The error message doesn't display properly");
        softAssert.assertAll();
    }
}
