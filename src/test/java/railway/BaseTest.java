package railway;

import common.Constant;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Driver;

public class BaseTest {

    @BeforeClass
    void beforeClass() {
        Constant.WEBDRIVER = Driver.setUp();
    }

    @AfterClass
    public void afterClass() {
        Constant.WEBDRIVER.close();
    }
}
