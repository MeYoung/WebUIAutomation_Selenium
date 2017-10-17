package com.frame.action;

import com.frame.logger.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by 米阳 on 2017/10/16.
 */
public class Find extends SeleniumDriver{
    final static LoggerControler log = LoggerControler.getLogger(Find.class);


    public static WebElement findElement(final By by) {
        WebElement webElement = null;
        try {
            webElement = new WebDriverWait(driver, 10).until(new ExpectedCondition<WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            });
        } catch (Exception e) {
            log.error("元素:" + by + "查找超时");
//            System.out.println("元素:" + by + "查找超时");
            e.printStackTrace();
        }
        return webElement;
    }

    public static List<WebElement> findElements(final By by) {
        List<WebElement> webElement = null;
        try {
            webElement = new WebDriverWait(driver, 10).until(new ExpectedCondition<List<WebElement>>() {
                public List<WebElement> apply(WebDriver driver) {
                    return driver.findElements(by);
                }
            });
        } catch (Exception e) {
            log.error("元素:" + by + "查找超时");
//            System.out.println("元素:" + by + "查找超时");
            e.printStackTrace();
        }
        return webElement;
    }
}
