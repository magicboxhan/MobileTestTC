package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/13.
 * 电影票 -- 影院选择页面
 */
public class MovieCinemaListPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public MovieCinemaListPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement(){
        try{
            return divCinema().get(0);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * div集合 - 影院列表
     */
    public List<WebElement> divCinema() {
        return d.findElements(By.className("cinemamsg"));
    }
}
