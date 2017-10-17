package com.frame.action;

import com.frame.logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 米阳 on 2017/10/16.
 */
public class SeleniumDriver {
    final static LoggerControler log = LoggerControler.getLogger(SeleniumDriver.class);

    private static final String DRIVER_FIREFOX = "firefox";
    private static final String DRIVER_CHROME = "chrome";
    private static final String DRIVER_PHANTOMJS = "phantomjs";
    private static final String DRIVER_IE = "ie";

    public static WebDriver driver;

    @Parameters({"browser" })
    public static WebDriver openBrowser(String browser) {
        String path = System.getProperty("user.dir");
        if (browser.equals(DRIVER_CHROME)) {
            System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals(DRIVER_IE)) {
            System.setProperty("webdriver.ie.driver", path + "/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browser.equals(DRIVER_FIREFOX)) {
            driver = new FirefoxDriver();
        } else {
            log.error("你传入的浏览器名有误为：" + browser);
        }
        //driver.manage().window().maximize();
        return driver;
    }


    //@Parameters({ "url", "browser" })
    public static WebDriver openBrowser(String url, String browser) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = null;
//        判断要打开的浏览器
        url = "http://" + url + "/wd/hub";
        if (browser.equals(DRIVER_CHROME)) {
            desiredCapabilities = DesiredCapabilities.chrome();
        } else if (browser.equals(DRIVER_IE)) {
            desiredCapabilities = DesiredCapabilities.internetExplorer();
        } else if (browser.equals(DRIVER_FIREFOX)) {
            desiredCapabilities = DesiredCapabilities.firefox();
        }
        driver = new RemoteWebDriver(new URL(url), desiredCapabilities);
        //driver.manage().window().maximize();
        return driver;
    }

}
