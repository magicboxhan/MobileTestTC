package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/4/9.
 * 我的页面
 */
public class MyPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public MyPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return imageViewMy();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 登录
     */
    public WebElement textViewLogin() {
        return d.findElementById("com.tongcheng.android:id/btn_mytc_login");
    }

    /**
     * TextView -- 用户编号
     */
    public WebElement textViewLoginName() {
        return d.findElementById("com.tongcheng.android:id/tv_login_name");
    }

    /**
     * TextView -- 签到
     */
    public WebElement textViewQiandao() {
        return d.findElementById("com.tongcheng.android:id/tv_mytc_qiandao");
    }

    /**
     * TextView -- 我的消息
     */
    public WebElement textViewMessage() {
        return d.findElementById("com.tongcheng.android:id/tv_mytc_message");
    }

    /**
     * TextView -- 全部订单
     */
    public WebElement textViewAllOrder() {
        return d.findElementById("com.tongcheng.android:id/tv_order_all");
    }

    /**
     * TextView -- 待支付
     */
    public WebElement textViewToPay() {
        return d.findElementById("com.tongcheng.android:id/tv_order_to_be_pad");
    }

    /**
     * TextView -- 待出行
     */
    public WebElement textViewToTravel() {
        return d.findElementById("com.tongcheng.android:id/tv_order_to_be_travel");
    }

    /**
     * TextView -- 待点评
     */
    public WebElement textViewToComment() {
        return d.findElementById("com.tongcheng.android:id/tv_order_to_comment");
    }

    /**
     * TextView -- 我的财富
     */
    public WebElement textViewWoDeCaiFu() {
        return d.findElementByName("我的财富");
    }

    /**
     * TextView -- 我的卡券
     */
    public WebElement textViewWoDeKaQuan() {
        return d.findElementByName("我的卡券");
    }

    /**
     * TextView -- 行程助手
     */
    public WebElement textViewAssistant() {
        return d.findElementById("com.tongcheng.android:id/tv_assistant");
    }

    /**
     * TextView -- 出境达人
     */
    public WebElement textViewChuJingCard() {
        return d.findElementById("com.tongcheng.android:id/tv_mytc_chuJingCard");
    }

    /**
     * TextView -- 1元景点日历
     */
    public WebElement textViewYiYuanJingDianRiLi() {
        return d.findElementByName("1元景点日历");
    }




    //==================== Functions ====================

    /**
     * 验证登录结果
     */
    public boolean funcVerifyLoginResult() {
        try {
            String loginName = textViewLoginName().getText();
            t.log(String.format("Pass -- 登录成功, 用户编号：[%s]", loginName));
            return true;
        } catch (Exception e) {
            t.log(">>>>>>>>>> Fail -- 登录失败");
            t.takeScreenshot(d, "loginFailed", "jpg");
            return false;
        }
    }

}
