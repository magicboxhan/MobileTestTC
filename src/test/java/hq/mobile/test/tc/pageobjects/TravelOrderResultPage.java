package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/22.
 * 周边游订单提交结果页
 */
public class TravelOrderResultPage extends CommonPage{

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public TravelOrderResultPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return testViewSuccess();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 订单提交成功
     */
    public WebElement testViewSuccess() {
        return d.findElementById("com.tongcheng.android:id/tv_success");
    }
}
