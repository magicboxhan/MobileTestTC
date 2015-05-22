package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/5/22.
 * 周边游订单填写页
 */
public class TravelWriteOrderPage extends CommonPage{

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public TravelWriteOrderPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return buttonCommit();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Button -- 提交订单
     */
    public WebElement buttonCommit() {
        return d.findElementById("com.tongcheng.android:id/btn_travel_order_commit");
    }

    /**
     * TextView -- 选择游玩日期
     */
    public WebElement textViewCalendar() {
        return d.findElementById("com.tongcheng.android:id/tv_scenery_date");
    }

    /**
     * EditText -- 出游人姓名
     */
    public WebElement editTextName() {
        return d.findElementById("com.tongcheng.android:id/et_tourist_name");
    }

    /**
     * EditText -- 出游人手机号
     */
    public WebElement editTextPhone() {
        return d.findElementById("com.tongcheng.android:id/et_tourist_mobile");
    }
}
