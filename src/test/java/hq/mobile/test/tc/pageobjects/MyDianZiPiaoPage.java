package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 电子票页
 */
public class MyDianZiPiaoPage extends CommonPage {

    public MyDianZiPiaoPage(AppiumDriver d) {
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
     * TextView -- 我的电子票
     */
    public WebElement textViewTitle() {
        return d.findElementByName("我的电子票");
    }
}
