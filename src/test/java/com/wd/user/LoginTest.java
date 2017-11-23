package com.wd.user;

import com.frame.action.Find;
import com.frame.action.SeleniumDriver;
import com.frame.logger.LoggerControler;
import com.frame.tools.MyAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

public class LoginTest {
    final static LoggerControler log = LoggerControler.getLogger(LoginTest.class);

    WebDriver driver;

    @Parameters({"browser" })
    @BeforeClass
    public void openChrome(String browser) {
        SeleniumDriver seleniumDriver = new SeleniumDriver();
        driver = seleniumDriver.openBrowser(browser);
    }


/*    @Test
    public void testLogin2() {
        driver.get("http://mail.163.com/");
        Login loginMail = new Login(driver);
        loginMail.login("meyoungtester", "xxxx");
    }*/

    @Test
    public void err() throws InterruptedException {
        log.info("测试失败重跑，截图");
        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        MyAssert.assertTrue(false);
    }

    int i=0;
    @Test
    public void tt() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("http://www.baidu.com");
        if(i==0){
            i++;
            Find.findElement(By.id("fasdf")).click();
        }else {
            log.info("正确");
        }



    }

    @Test
    public void good() throws InterruptedException {
        Thread.sleep(2000);
        log.info("fassfaff");
    }

    @AfterClass
    public void closedChrome() throws InterruptedException {
        driver.quit();
    }
}
