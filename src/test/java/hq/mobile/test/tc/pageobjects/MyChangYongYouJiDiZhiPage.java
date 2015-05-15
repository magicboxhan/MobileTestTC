package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/15.
 * 常用邮寄地址页
 */
public class MyChangYongYouJiDiZhiPage extends CommonPage {

    public MyChangYongYouJiDiZhiPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewAdd();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 添加常用邮寄地址
     */
    public WebElement textViewAdd() {
        return d.findElementByName("添加常用邮寄地址");
    }

    /**
     * TextView -- 返回按钮
     */
    public WebElement textViewBack() {
        return d.findElementById("com.tongcheng.android:id/img_actionbar_icon");
    }
}
