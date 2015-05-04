package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/28.
 * 订单列表页
 */
public class OrderListPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public OrderListPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * TextView集合 -- 取消订单
     */
    public List<WebElement> textViewCancelOrder() {
        return d.findElementsById("com.tongcheng.android:id/tv_cancel");
    }

    /**
     * RelativeLayout集合 -- 取消原因
     */
    public List<WebElement> relativeLayoutCancelReason() {
        return d.findElementsById("com.tongcheng.android:id/filter_item");
    }

    /**
     * TextView集合 -- 删除订单
     */
    public List<WebElement> textViewDeleteOrder() {
        return d.findElementsById("com.tongcheng.android:id/tv_delete");
    }

    /**
     * Button -- 确认删除按钮
     */
    public WebElement buttonConfirmDelete() {
        return d.findElementById("com.tongcheng.android:id/btn_dialog_right");
    }

    //==================== Functions ====================

    /**
     * 取消并删除所有订单
     */
    public void funcCancelDeleteAllOrders() {
        while ((textViewCancelOrder().size() > 0) || (textViewDeleteOrder().size() > 0)) {
            if (textViewCancelOrder().size() > 0) {
                textViewCancelOrder().get(0).click();
                relativeLayoutCancelReason().get(0).click();
            } else {
                textViewDeleteOrder().get(0).click();
                buttonConfirmDelete().click();
            }
        }
    }
}
