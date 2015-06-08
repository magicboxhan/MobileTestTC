package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/6/2.
 * 景区订单提交结果页
 */
public class SceneryOrderResultPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public SceneryOrderResultPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    /**
     * 该页面有两种成功判断标准，元素1代表：订单提交成功
     */
    public WebElement keyElement() {
        try {
            return textViewSuccess();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 该页面有两种成功判断标准，元素2代表：待支付
     */
    public WebElement keyElement2() {
        try {
            return textViewTitle();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 该页面有两种成功判断标准，元素3代表：提交成功
     */
    public WebElement keyElement3() {
        try {
            return textViewTitle2();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 订单提交成功
     */
    public WebElement textViewSuccess() {
        return d.findElementById("com.tongcheng.android:id/tv_pay_success_title");
    }

    /**
     * TextView -- 标题：选择支付方式
     */
    public WebElement textViewTitle() {
        return d.findElementByName("支付方式");
    }

    /**
     * TextView -- 标题：提交成功
     */
    public WebElement textViewTitle2() {
        return d.findElementByName("支付方式");
    }


    //==================== Functions ====================

    /**
     * 自检
     *
     * @return 自检是否通过
     */
    public boolean funcSelfcheck(String pageName) {
        if (!checkKeyElement) {
            t.log("不需要自检");
            return true;
        }
        t.log(String.format("执行页面 [%s] 的自检功能", pageName));
        if ((keyElement() != null) || (keyElement2() != null) || (keyElement3() != null)) {
            t.log("Pass -- 自检通过");
            funcSwitchToNativeView();
            t.takeScreenshot(d, "SelfCheckPassed", "jpg");
            return true;
        } else {
            t.log(">>>>>>>>>> 自检失败");
            t.takeScreenshot(d, "SelfCheckFailed", "jpg");
            return false;
        }
    }
}
