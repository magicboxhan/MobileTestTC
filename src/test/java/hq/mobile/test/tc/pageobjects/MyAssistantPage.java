package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 行程助手页
 */
public class MyAssistantPage extends CommonPage {

    public MyAssistantPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewTitle();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 行程助手
     */
    public WebElement textViewTitle() {
        return d.findElementByName("行程助手");
    }

    /**
     * TextView -- 返回按钮
     */
    public WebElement textViewBack() {
        return d.findElementById("com.tongcheng.android:id/img_actionbar_icon");
    }
}
