package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/13.
 * 我的消息页面
 */
public class MyMessagePage extends CommonPage {

    public MyMessagePage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewSubTitle();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 标题
     */
    public WebElement textViewTitle() {
        return d.findElementByName("我的消息");
    }

    /**
     * TextView -- 标题（用户消息/系统消息）
     */
    public WebElement textViewSubTitle() {
        return d.findElementById("com.tongcheng.android:id/tv_title");
    }
}
