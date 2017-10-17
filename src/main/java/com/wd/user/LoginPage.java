package com.wd.user;

import com.frame.action.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by 米阳 on 14/10/2017.
 */
public class LoginPage {

    // 定位 ifrmae
    public static By loginFrame = By.id("x-URS-iframe");
    // 定位 邮箱地址输入框
    public static By emailField = By.name("email");
    // 定位 密码输入框
    public static By pwdFiled = By.name("password");
    // 定位 登录按钮
    public static By loginBtn = By.id("dologin");


    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 往邮箱文本框输入邮箱
     *
     * @param email 邮箱地址
     */
    public void sendKeysEmail(String email) {
        Action.clear(emailField);
        Action.sendText(emailField, email);

    }

    /**
     * 往密码文本框输入密码
     *
     * @param pwd 密码
     */
    public void sendKeysPWD(String pwd) {
        Action.clear(pwdFiled);
        Action.sendText(pwdFiled, pwd);
    }

}
