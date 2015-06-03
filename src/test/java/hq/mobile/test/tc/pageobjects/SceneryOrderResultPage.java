package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/6/2.
 * 景区订单提交结果页
 */
public class SceneryOrderResultPage extends CommonPage{

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
            return textViewTitle();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 标题：选择支付方式
     */
    public WebElement textViewTitle() {
        return d.findElementByName("支付方式");
    }
}
