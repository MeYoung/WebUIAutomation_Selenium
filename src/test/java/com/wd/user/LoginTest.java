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

public class LoginTest {
    final static LoggerControler log = LoggerControler.getLogger(LoginTest.class);

    WebDriver driver;

    //@Parameters({"browser" })
    @BeforeClass
    public void openChrome() {
        SeleniumDriver seleniumDriver = new SeleniumDriver();
        driver = seleniumDriver.openBrowser("chrome");
    }


    @Test
    public void testLogin2() {
        driver.get("http://mail.163.com/");
        Login loginMail = new Login(driver);
        loginMail.login("meyoungtester", "meyoung123");
    }

    @Test
    public void err() {
        log.info("测试失败重跑，截图");
        driver.get("http://www.baidu.com");
        MyAssert.assertTrue(false);
    }

    int i=0;
    @Test
    public void tt() {
        driver.get("http://www.baidu.com");
        if(i==0){
            i++;
            Find.findElement(By.id("fasdf")).click();
        }else {
            log.info("正确");
        }


    }

    @AfterClass
    public void closedChrome() throws InterruptedException {
        driver.quit();
    }
}
