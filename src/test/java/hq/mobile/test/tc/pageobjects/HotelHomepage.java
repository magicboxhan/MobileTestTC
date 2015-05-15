package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/6.
 * 酒店首页
 */
public class HotelHomepage extends CommonPage {

    public HotelHomepage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * TextView - 当前城市名称
     */
    public WebElement textViewCityName() {
        return d.findElementById("com.tongcheng.android:id/tv_city_name");
    }

    /**
     * TextView - 入住日期
     */
    public WebElement textViewCheckInDate() {
        return d.findElementById("com.tongcheng.android:id/tv_city_check_in_date");
    }

    /**
     * TextView - 离店日期
     */
    public WebElement textViewCheckOutDate() {
        return d.findElementById("com.tongcheng.android:id/ll_city_check_out_date");
    }

    /**
     * TextView - 酒店名、地址
     */
    public WebElement textViewCityKey() {
        return d.findElementById("com.tongcheng.android:id/tv_city_key");
    }

    /**
     * TextView - 价格、星级
     */
    public WebElement textViewCityPrice() {
        return d.findElementById("com.tongcheng.android:id/tv_city_price");
    }

    /**
     * Button - 搜索按钮
     */
    public WebElement buttonQuery() {
        return d.findElementById("com.tongcheng.android:id/btn_query");
    }


    //==================== Functions ====================
}
