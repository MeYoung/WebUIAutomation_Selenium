package com.wd.user;

import com.frame.action.Action;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 登陆
     *
     * @param emial 邮箱地址
     * @param pwd   密码
     */
    public void login(String emial, String pwd) {
        LoginPage loginPage = new LoginPage(driver);
        Action.switchFrame(LoginPage.loginFrame);
        loginPage.sendKeysEmail(emial);
        loginPage.sendKeysPWD(pwd);
        Action.click(LoginPage.loginBtn, "点击登陆录按钮");
    }
}
