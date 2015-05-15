package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/15.
 * 出境游轮收藏页
 */
public class MyChuJingYouLunShouCangPage extends CommonPage {
    public MyChuJingYouLunShouCangPage(AppiumDriver d) {
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
     * TextView -- 出境游收藏
     */
    public WebElement textViewSubTitle() {
        return d.findElementByName("出境游收藏");
    }


}
