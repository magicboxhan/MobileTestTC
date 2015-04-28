package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hanqing on 2015/3/30.
 * 景点详情页
 */
public class SceneryDetailPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public SceneryDetailPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * TextView -- 景点名称
     */
    public WebElement textViewSceneryName() {
        return d.findElementById("com.tongcheng.android:id/sceneryName");
    }

    /**
     * TextView -- 景点评论数
     */
    public WebElement textViewCommentCount() {
        return d.findElementById("com.tongcheng.android:id/commentCount");
    }

    /**
     * TextView -- 点评
     */
    public WebElement textViewComment() {
        return d.findElementById("com.tongcheng.android:id/comment");
    }

    /**
     * TextView -- 图片
     */
    public WebElement textViewPicture() {
        return d.findElementById("com.tongcheng.android:id/picture");
    }

    /**
     * TextView -- 周边
     */
    public WebElement textViewNear() {
        return d.findElementById("com.tongcheng.android:id/near");
    }

    /**
     * TextView -- 简介
     */
    public WebElement textViewDes() {
        return d.findElementById("com.tongcheng.android:id/des");
    }

    /**
     * TextView -- 地址
     */
    public WebElement textViewAddress() {
        return d.findElementById("com.tongcheng.android:id/address");
    }

    /**
     * TextView -- 票名
     */
    public WebElement textViewGroupName() {
        return d.findElementById("com.tongcheng.android:id/groupName");
    }

    /**
     * TextView -- 票价
     */
    public WebElement textViewGroupPrice() {
        return d.findElementById("com.tongcheng.android:id/groupPrice");
    }

    /**
     * Button -- 预订
     */
    public WebElement buttonOrder() {
        return d.findElementById("com.tongcheng.android:id/btn_order");
    }


    //==================== Functions ====================


}
