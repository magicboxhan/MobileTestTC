package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/6/2.
 * 景区首页
 */
public class SceneryHomepage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public SceneryHomepage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewSearchText();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 搜索框
     */
    public WebElement textViewSearchText() {
        return d.findElementById("com.tongcheng.android:id/tv_search_value");
    }
}
