package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/15.
 * 常用旅客页
 */
public class MyChangYongLvKePage extends CommonPage {

    public MyChangYongLvKePage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return buttonAdd();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Button -- 添加常用旅客
     */
    public WebElement buttonAdd() {
        return d.findElementById("com.tongcheng.android:id/contact_btn_add");
    }

    /**
     * TextView -- 返回按钮
     */
    public WebElement textViewBack() {
        return d.findElementById("com.tongcheng.android:id/img_actionbar_icon");
    }
}
