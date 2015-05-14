package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 我的财富页
 */
public class MyWealthPage extends CommonPage{

    public MyWealthPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewJiangJin();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 奖金账户
     */
    public WebElement textViewJiangJin() {
        return d.findElementByName("奖金账户");
    }

    /**
     * TextView -- 立返账户
     */
    public WebElement textViewLiFan() {
        return d.findElementByName("立返账户");
    }

    /**
     * TextView -- 抵现红包
     */
    public WebElement textViewDiXian() {
        return d.findElementByName("抵现红包");
    }

    /**
     * TextView -- 返现红包
     */
    public WebElement textViewFanXian() {
        return d.findElementByName("返现红包");
    }
}
