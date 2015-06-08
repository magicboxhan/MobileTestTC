package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/27.
 * 日历选择页
 */
public class CalendarPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public CalendarPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return viewCalendarGrid().get(0);
        } catch (Exception e) {
            return null;
        }
    }

}
