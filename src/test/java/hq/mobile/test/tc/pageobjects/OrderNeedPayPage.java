package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/13.
 * 待支付订单页
 */
public class OrderNeedPayPage extends CommonPage {

    public OrderNeedPayPage(AppiumDriver d) {
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
     * TextView -- 返回按钮
     */
    public WebElement textViewBack() {
        return d.findElementById("com.tongcheng.android:id/img_actionbar_icon");
    }

    /**
     * TextView -- 标题
     */
    public WebElement textViewTitle() {
        return d.findElementByName("待支付");
    }
}
