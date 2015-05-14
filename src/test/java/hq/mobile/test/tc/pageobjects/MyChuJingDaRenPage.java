package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 出境达人页
 */
public class MyChuJingDaRenPage extends CommonPage {

    public MyChuJingDaRenPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return divWXShare();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Div -- 微信分享
     */
    public WebElement divWXShare() {
        return d.findElement(By.id("wxShare"));
    }
}
