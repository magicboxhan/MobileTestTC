package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 周末卡页
 */
public class MyZhouMoKaPage extends CommonPage {

    public MyZhouMoKaPage(AppiumDriver d) {
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
     * TextView -- 周末卡
     */
    public WebElement textViewTitle() {
        return d.findElementByName("周末卡");
    }
}
