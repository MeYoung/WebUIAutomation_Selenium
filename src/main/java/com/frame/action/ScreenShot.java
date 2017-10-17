package com.frame.action;

import com.frame.logger.LoggerControler;
import com.frame.tools.DateFormat;
import com.frame.tools.MyFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

/**
 * Created by 米阳 on 2017/10/16.
 */
public class ScreenShot extends SeleniumDriver {
    protected static final LoggerControler log = LoggerControler.getLogger(ScreenShot.class);

    static String path = System.getProperties().getProperty("user.dir") + "/error/";

    /**
     * 错误截图
     **/
    public static void screenShots() {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        try {
//            根据日期创建文件夹
            MyFile.creatFile(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT));
            FileUtils.copyFile(file, new File(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT) + "/" +
                    DateFormat.format(DateFormat.REPORT_CSV_FORMAT) + ".jpg"));
        } catch (IOException e) {
            log.error("截图失败！！");
            e.printStackTrace();
        }
    }

    /**
     * 错误截图
     **/
    public static void screenShots(String name) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        try {
            MyFile.creatFile(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT));
            FileUtils.copyFile(file, new File(path + DateFormat.format(DateFormat.CHECK_LOG_FORMAT) + "/" + name + ".jpg"));
        } catch (IOException e) {
            log.error("截图失败！！");
            e.printStackTrace();
        }
    }

    /**
     * 判断文件夹，没有就新建
     */
/*    public static void fileExists() {
        String fileName = DateUtil.format(DateUtil.CHECK_LOG_FORMAT);
        File file = new File(path + fileName);
        if (!file.exists()) {
            file.mkdirs();
        }
    }*/
}
