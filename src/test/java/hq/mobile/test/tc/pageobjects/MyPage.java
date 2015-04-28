package hq.mobile.test.tc.pageobjects;

import hq.mobile.test.tc.common.BasicPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/4/9.
 */
public class MyPage extends BasicPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public MyPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * TextView -- 登录
     */
    public WebElement textViewLogin() {
        return d.findElementById("com.tongcheng.android:id/btn_mytc_login");
    }

    /**
     * TextView -- 用户编号
     */
    public WebElement textViewLoginName() {
        return d.findElementById("com.tongcheng.android:id/tv_login_name");
    }


    //==================== Functions ====================

    /**
     * 验证登陆结果
     */
    public boolean funcVerifyLoginResult() {
        try {
            String loginName = textViewLoginName().getText();
            t.log(String.format("Pass -- 登录成功, 用户编号：[%s]", loginName));
            return true;
        } catch (Exception e) {
            t.log("<<<<< Fail -- 登录失败");
            t.takeScreenshot(d, "loginFailed", "jpg");
            return false;
        }
    }

}