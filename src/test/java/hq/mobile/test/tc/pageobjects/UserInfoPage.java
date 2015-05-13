package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/11.
 * 个人资料页
 */
public class UserInfoPage extends CommonPage {

    public UserInfoPage(AppiumDriver d){
        super(d);
        checkKeyElement = true;
    }



    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewNickName();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 昵称
     */
    public WebElement textViewNickName() {
        return d.findElementById("com.tongcheng.android:id/myaccount_nickname");
    }

    /**
     * TextView -- 返回按钮
     */
    public WebElement textViewBack() {
        return d.findElementById("com.tongcheng.android:id/actionbar_title");
    }
}
