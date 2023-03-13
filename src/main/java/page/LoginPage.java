package page;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private By txtEmail = By.xpath("//input[@id='username']");
    private By txtPassword = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@type='submit']");
    private By msgWelcome = By.xpath("//div[@class='account' and contains(normalize-space(),'Welcome ')]");
    private By msgErrorLoginForm = By.xpath("//p[@class='message error LoginForm']");
    private By msgErrorValidField = By.xpath("//label[@class='validation-error' and @for ='username']");

    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getMsgWelcome() {
        return Constant.WEBDRIVER.findElement(msgWelcome);
    }

    public WebElement getMsgErrorLoginForm() {
        return Constant.WEBDRIVER.findElement(msgErrorLoginForm);
    }

    public WebElement getMsgErrorInvalidField() {
        return Constant.WEBDRIVER.findElement(msgErrorValidField);
    }

    public void enterEmail(String email) {
        this.getTxtEmail().sendKeys(email);
    }

    public void enterPassword(String password) {
        this.getTxtPassword().sendKeys(password);
    }

    public void clickLogin() {
        getBtnLogin().click();
    }

    public String getTextMsgWelcome() {
        return getMsgWelcome().getText();
    }

    public String getTextMsgErrorLogin() {
        return getMsgErrorLoginForm().getText();
    }

    public String getTextMsgErrorInvalidField() {
        return getMsgErrorInvalidField().getText();
    }

    public void loginWithInvalidAccountSeveralTimes(int times, String email, String password) {
        for (int i = 0; i < times; i++) {
            this.login(email, password);
        }
    }

    public void login(String email, String password) {
        this.enterEmail(email);
        this.enterPassword(password);
        clickLogin();
    }
}
