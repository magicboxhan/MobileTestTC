package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 奖金账户页
 */
public class MyJiangJinPage extends CommonPage {

    public MyJiangJinPage(AppiumDriver d) {
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
     * TextView -- 奖金账户
     */
    public WebElement textViewTitle() {
        return d.findElementByName("奖金账户");
    }
}
