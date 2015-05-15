package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/13.
 * 待点评订单页
 */
public class OrderNeedCommentPage extends CommonPage {

    public OrderNeedCommentPage(AppiumDriver d) {
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
        return d.findElementByName("待点评");
    }
}
