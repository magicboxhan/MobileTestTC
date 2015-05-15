package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/15.
 * 攻略收藏页
 */
public class MyGongLueShouCangPage extends CommonPage {

    public MyGongLueShouCangPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewSubTitle(0);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 标签（城市/景点/游记）
     */
    public WebElement textViewSubTitle(int index) {
        return d.findElementsById("com.tongcheng.android:id/tv_title").get(index);
    }
}
