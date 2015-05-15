package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/15.
 * 酒店收藏页
 */
public class MyJiuDianShouCangPage extends CommonPage {

    public MyJiuDianShouCangPage(AppiumDriver d) {
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
     * TextView -- 酒店收藏
     */
    public WebElement textViewTitle() {
        return d.findElementByName("酒店收藏");
    }
}
