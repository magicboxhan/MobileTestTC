package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/5/22.
 * 周边游套餐列表页
 */
public class TravelTicketListPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public TravelTicketListPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return buttonBook().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Button集合 -- 预订套餐
     */
    public List<WebElement> buttonBook() {
        return d.findElementsById("com.tongcheng.android:id/btn_book");
    }
}
