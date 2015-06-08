package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/22.
 * 周边游首页
 */
public class TravelHomepage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public TravelHomepage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return aSearchText();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * a -- 搜索框
     */
    public WebElement aSearchText() {
        return d.findElement(By.className("searchText"));
    }
}
