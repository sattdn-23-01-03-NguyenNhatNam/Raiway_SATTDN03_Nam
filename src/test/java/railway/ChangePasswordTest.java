package railway;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ChangePasswordPage;
import page.HomePage;
import page.LoginPage;

public class ChangePasswordTest extends BaseTest {
    private HomePage homePage = new HomePage();
    private ChangePasswordPage changePassword = new ChangePasswordPage();
    private LoginPage loginPage = new LoginPage();

    @Test(description = "User can change password")
    public void TC09() {
        homePage.open();
        homePage.clickOnTabLogin();
        loginPage.login(Constant.Username, Constant.Password);
        homePage.clickOnTabChangePassword();
        changePassword.changePassword(Constant.Password, "12345678", "12345678");

        Assert.assertEquals(changePassword.getTextMsgSuccess(), "Your password has been updated");
    }
}
