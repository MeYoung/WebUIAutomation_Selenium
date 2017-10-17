package com.frame.action;

import com.frame.logger.LoggerControler;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 米阳 on 2017/10/16.
 */
public class Action extends SeleniumDriver {
    final static LoggerControler log = LoggerControler.getLogger(Action.class);


    public static void click(By by, String... text) {
        Find.findElement(by).click();
        if (text.length > 0) {
            log.info("点击：" + text[0]);
        } else {
            log.info("点击：" + by);
        }

    }

    public static void clear(By by) {
        Find.findElement(by).clear();
        log.info("清空" + by);
    }

    public static void sendText(By by, String text) {
        WebElement element = Find.findElement(by);
        element.clear();
        element.sendKeys(text);
        log.info("在" + by + "输入" + text);
    }

    public static String getText(By by) {
        String text = Find.findElement(by).getText();
        log.info("获取了" + by + "文本为" + text);
        return text;
    }

    public static ArrayList getTexts(By by) {
        ArrayList arrayList = new ArrayList();
        List<WebElement> list = Find.findElements(by);
        for (int j = 0; j < list.size(); j++) {
            String text = list.get(j).getText();
            arrayList.add(text);
        }
        return arrayList;
    }

    public static Boolean isDisplay(By by) {
        Boolean isDisplay = Find.findElement(by).isDisplayed();
        if (isDisplay) {
            log.info(by + "正常显示");
        } else {
            log.info(by + ":处于未激活");
        }
        return isDisplay;

    }

    public static Boolean isSelected(By by) {
        Boolean isSelected = Find.findElement(by).isSelected();
        if (isSelected) {
            log.info(by + "已经被选中");
        } else {
            log.info(by + "未被选中");
        }
        return isSelected;
    }

    public static Boolean isEnabled(By by) {
        Boolean isEnable = Find.findElement(by).isEnabled();
        if (isEnable) {
            log.info(by + "处于激活状态");
        } else {
            log.info(by + "处于非激活状态");
        }
        return isEnable;
    }

    public static void jsExecutor(String js) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript(js);
        log.info("执行JS：" + js);
    }

    public static void rightClick(By by) {
        WebElement webElement = Find.findElement(by);
        Actions action = new Actions(driver);
        action.contextClick(webElement).perform();
        log.info("在" + by + "处右击");
    }

    public static void doubleClick(By by) {
        WebElement webElement = Find.findElement(by);
        Actions action = new Actions(driver);
        action.doubleClick(webElement).perform();
        log.info("在" + by + "处双击");
    }

    public static void moveToElement(By by) {
        WebElement webElement = Find.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
        log.info("将鼠标移至" + by + "处");
    }

    public static void dragAndDrop(By by, int x, int y) {
        WebElement webElement = Find.findElement(by);
        Actions action = new Actions(driver);
        action.dragAndDropBy(webElement, x, y).perform();
        log.info("将元素" + by + "拖拽到(" + x + "," + y + ")处");
    }

    public static void clickAndHold(By oneby, By twoby) {
        WebElement oneElement = Find.findElement(oneby);
        WebElement twoElement = Find.findElement(twoby);
        Actions action = new Actions(driver);
        action.clickAndHold(oneElement).moveToElement(twoElement).release(oneElement).perform();
        log.info("将元素" + oneby + "拖到" + twoby + "处");
    }

    public static void multiSelect(By select, By option, int oneid, int twoid) {
        WebElement selection = Find.findElement(select);
        List<WebElement> options = selection.findElements(option);
        Actions builder = new Actions(driver);
        builder.click(options.get(oneid)).keyDown(Keys.SHIFT).click(options.get(twoid)).keyUp(Keys.SHIFT).perform();
        log.info("选择多选框中的" + (oneid + 1) + "和" + (twoid + 1) + "选项");

    }

    public static void selectByIndex(By by, int i) {
        WebElement cashSelect = Find.findElement(by);
        Select select = new Select(cashSelect);
        select.selectByIndex(i);
        log.info("用户选择了第" + i + "个选项");
    }

    public static void selectByValue(By by, String value) {
        WebElement cashSelect = Find.findElement(by);
        Select select = new Select(cashSelect);
        select.selectByValue(value);
        log.info("选择了Value为:" + value + " 选项");
    }

    public static void selectBy(By by, String text) {
        WebElement cashSelect = Find.findElement(by);
        Select select = new Select(cashSelect);
        select.selectByVisibleText(text);
        log.info("用户选择了:" + text + " 选项");
    }

    public static void switchWindow() {
        String handle = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            driver.switchTo().window(handles);
        }
        log.info("窗口切换");
    }

    public static void switchFrame(By by) {
        WebElement frame = Find.findElement(by);
        driver.switchTo().frame(frame);
        log.info("frame切换");
    }


    public static void backBrowser() {
        driver.navigate().back();
        log.info("页面后退");
    }

    public static void forwardBrowser() {
        driver.navigate().forward();
        log.info("页面前进");
    }

    public static void refreshBrowser() {
        driver.navigate().refresh();
        log.info("页面刷新");
    }

    public static void maxBrowser() {
        driver.manage().window().maximize();
        log.info("页面最大化");
    }

    public static void setBrowserSize(int x, int y) {
        Dimension dimension = new Dimension(x, y);
        driver.manage().window().setSize(dimension);
        log.info("页面大小:(" + x + "," + y + ")");
    }

    public static void closeAllBrowser() {
        driver.quit();
        log.info("结束测试,关闭所有浏览器");
    }

    public static void closeBrowser() {
        driver.close();
        log.info("关闭浏览器");
    }

    public static String getUrlBrowser() {
        String url = driver.getCurrentUrl();
        log.info("获取当前url");
        return url;
    }

    public static String getTitleBrowser() {
        String title = driver.getTitle();
        log.info("获取页面Title");
        return title;
    }

}
