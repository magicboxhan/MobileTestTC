package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 我的卡券页
 */
public class MyCardPage extends CommonPage {

    public MyCardPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewDianZiPiao();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 电子票
     */
    public WebElement textViewDianZiPiao() {
        return d.findElementByName("电子票");
    }

    /**
     * TextView -- 周末卡
     */
    public WebElement textViewZhouMoKa() {
        return d.findElementByName("周末卡");
    }

    /**
     * TextView -- 爱旅卡
     */
    public WebElement textViewAiLvKa() {
        return d.findElementByName("爱旅卡");
    }

    /**
     * TextView -- 有票卡
     */
    public WebElement textViewYouPiaoKa() {
        return d.findElementByName("有票卡");
    }
}
