package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/15.
 * 一元景点日历
 */
public class MyYiYuanJingDianPage extends CommonPage {

    public MyYiYuanJingDianPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return linearLayoutCalendar();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * LinearLayout -- 日历
     */
    public WebElement linearLayoutCalendar() {
        return d.findElementById("com.tongcheng.android:id/calendar_view");
    }
}
