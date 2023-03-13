package page;

import common.Constant;
import common.Enums;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    private String tabDynamicLocator = "//a[contains(@href, '%s')]";

    public By getTabGeneral(String tabName) {
        return By.xpath(String.format(tabDynamicLocator, tabName));
    }

    public WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(getTabGeneral(Enums.Login.getValue()));
    }

    public WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(getTabGeneral(Enums.Register.getValue()));
    }

    public WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(getTabGeneral(Enums.BookTicketPage.getValue()));
    }

    public WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(getTabGeneral(Enums.Logout.getValue()));
    }

    public WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(getTabGeneral(Enums.MyTicket.getValue()));
    }

    public WebElement getChangePassword() {
        return Constant.WEBDRIVER.findElement(getTabGeneral(Enums.ChangePassword.getValue()));
    }

    public void clickOnTabRegister() {
        getTabRegister().click();
    }

    public void clickOnTabLogin() {
        getTabLogin().click();
    }

    public void clickOnTabBookTicket() {
        getTabBookTicket().click();
    }

    public void clickOnTabLogout() {
        getTabLogout().click();
    }

    public void clickOnTabChangePassword() {
        getChangePassword().click();
    }
}
