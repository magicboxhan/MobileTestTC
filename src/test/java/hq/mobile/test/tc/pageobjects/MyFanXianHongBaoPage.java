package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 返现红包页
 */
public class MyFanXianHongBaoPage extends CommonPage {

    public MyFanXianHongBaoPage(AppiumDriver d) {
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
     * Li -- 标题（未使用/已失效）
     */
    public WebElement textViewSubTitle() {
        return d.findElement(By.className("tab_list")).findElement(By.tagName("li"));
    }
}
