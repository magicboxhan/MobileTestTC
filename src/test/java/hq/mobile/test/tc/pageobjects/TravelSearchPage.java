package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/22.
 * 周边游搜索页
 */
public class TravelSearchPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public TravelSearchPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return editTextKeyword();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * EditText -- 搜索框
     */
    public WebElement editTextKeyword() {
        return d.findElementById("com.tongcheng.android:id/et_content");
    }

    /**
     * TextView -- 搜索按钮
     */
    public WebElement textViewSearch() {
        return d.findElementById("com.tongcheng.android:id/tv_actionbar_menu_item");
    }


    //==================== Functions ====================

    /**
     * 搜索关键字
     *
     * @param keyword 关键字
     */
    public void funcSearch(String keyword) {
        editTextKeyword().sendKeys(keyword);
        textViewSearch().click();
    }
}
