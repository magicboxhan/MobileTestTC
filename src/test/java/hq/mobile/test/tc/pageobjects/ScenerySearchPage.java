package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/6/2.
 * 景区搜索页
 */
public class ScenerySearchPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public ScenerySearchPage(AppiumDriver d) {
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

    /**
     * TextView -- 搜索结果关键字列表
     */
    public List<WebElement> textViewSceneryName() {
        return d.findElementsById("com.tongcheng.android:id/sceneryNameTextView");
    }


    //==================== Functions ====================

    /**
     * 搜索关键字 -- 通过点击搜索按钮搜索
     *
     * @param keyword 关键字
     */
    public void funcSearchByClickButton(String keyword) {
        editTextKeyword().sendKeys(keyword);
        textViewSearch().click();
    }

    /**
     * 搜索关键字 -- 通过点击搜索按钮搜索
     *
     * @param keyword 关键字
     */
    public void funcSearchByClickName(String keyword) {
        editTextKeyword().sendKeys(keyword);
        textViewSceneryName().get(0).click();
    }

}
