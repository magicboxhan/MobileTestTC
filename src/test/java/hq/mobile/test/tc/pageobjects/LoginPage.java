package hq.mobile.test.tc.pageobjects;

import hq.mobile.test.tc.common.BasicPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/4/9.
 */
public class LoginPage extends BasicPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public LoginPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * EditText -- 用户名
     */
    public WebElement editTextAccount() {
        return d.findElementById("com.tongcheng.android:id/login_account");
    }

    /**
     * EditText -- 密码
     */
    public WebElement editTextPassword() {
        return d.findElementById("com.tongcheng.android:id/login_password");
    }

    /**
     * Button -- 登录按钮
     */
    public WebElement buttonCommit() {
        return d.findElementById("com.tongcheng.android:id/login_commit_btn");
    }

    //==================== Functions ====================

    /**
     * 功能 -- 登录
     *
     * @param uid 用户名
     * @param pwd 密码
     */
    public void funcLogin(String uid, String pwd) {
        editTextAccount().clear();
        editTextAccount().sendKeys(uid);
        editTextPassword().clear();
        editTextPassword().sendKeys(pwd);
        buttonCommit().click();
    }

}
