package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/4/9.
 */
public class StartPage extends CommonPage {

    public StartPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * 按钮 -- 跳过
     */
    public WebElement imageViewSkip() {
        return d.findElementById("com.tongcheng.android:id/iv_close");
    }
}
