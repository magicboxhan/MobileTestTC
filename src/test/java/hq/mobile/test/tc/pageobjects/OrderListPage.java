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
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewSubTitle(0);
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
     * TextView -- 标题（三个月内/三个月前）
     */
    public WebElement textViewSubTitle(int index) {
        return d.findElementsById("com.tongcheng.android:id/tv_title").get(index);
    }

    /**
     * TextView集合 -- 取消订单
     */
    public List<WebElement> textViewCancelOrder() {
//        return d.findElementsById("com.tongcheng.android:id/tv_cancel");
        return d.findElementsByName("取消订单");
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
//        return d.findElementsById("com.tongcheng.android:id/tv_delete");
        return d.findElementsByName("删除订单");
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
                buttonConfirmDelete().click();
                t.log("取消订单");
            } else {
                textViewDeleteOrder().get(0).click();
                buttonConfirmDelete().click();
                t.log("删除订单");
            }
        }
    }
}
