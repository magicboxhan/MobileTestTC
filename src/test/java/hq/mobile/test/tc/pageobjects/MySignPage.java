package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/11.
 * 签到页
 */
public class MySignPage extends CommonPage {

    public MySignPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return viewSign();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 标题按钮
     */
    public WebElement textViewTitle() {
        try {
            return d.findElementById("com.tongcheng.android:id/tv_actionbar_title");
        } catch (Exception e) {
            return d.findElementById("com.tongcheng.android:id/actionbar_title");
        }
    }

    /**
     * TextView -- 返回按钮
     */
    public WebElement textViewBack() {
        try {
            return d.findElementById("com.tongcheng.android:id/actionbar_back");
        } catch (Exception e) {
            return d.findElementById("com.tongcheng.android:id/img_actionbar_icon");
        }
    }

    /**
     * div -- 签到（通过webview定位元素）
     */
    public WebElement divSign() {
        return d.findElement(By.id("signBtn"));
    }

    /**
     * view -- 签到（通过native定位元素）
     */
    public WebElement viewSign() {
        return d.findElementByName("签到");
    }

}
