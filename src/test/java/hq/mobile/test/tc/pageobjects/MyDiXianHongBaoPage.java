package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 抵现红包页
 */
public class MyDiXianHongBaoPage extends CommonPage {

    public MyDiXianHongBaoPage(AppiumDriver d) {
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
     * TextView -- 标题（未使用/已失效）
     */
    public WebElement textViewSubTitle(){
        return d.findElementById("com.tongcheng.android:id/tv_title");
    }

    /**
     * TextView -- 返回按钮
     */
    public WebElement textViewBack() {
        return d.findElementById("com.tongcheng.android:id/img_actionbar_icon");
    }
}
