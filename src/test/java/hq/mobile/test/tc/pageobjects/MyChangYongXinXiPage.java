package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/15.
 * 常用信息页
 */
public class MyChangYongXinXiPage extends CommonPage {

    public MyChangYongXinXiPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewChangYongLvKe();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 常用旅客
     */
    public WebElement textViewChangYongLvKe() {
        return d.findElementByName("常用旅客");
    }

    /**
     * TextView -- 常用邮寄地址
     */
    public WebElement textViewChangYongYouJiDiZhi() {
        return d.findElementByName("常用邮寄地址");
    }
}
