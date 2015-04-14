package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/10.
 * 电影票 - 城市选择页面
 */
public class MovieCityListPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public MovieCityListPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * div - 所有城市列表
     */
    public WebElement divAllCityList() {
        return d.findElement(By.id("allCityList"));
    }

    /**
     * dd集合 - 所有城市
     */
    public List<WebElement> ddAllCity() {
        return divAllCityList().findElements(By.tagName("dd"));
    }

    /**
     * dd - 根据索引获取城市元素
     *
     * @param index 索引
     */
    public WebElement ddCityOfAll(int index) {
        return ddAllCity().get(index);
    }


    //==================== Functions ====================


}
