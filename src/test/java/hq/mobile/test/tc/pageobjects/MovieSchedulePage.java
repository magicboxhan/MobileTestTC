package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/29.
 */
public class MovieSchedulePage extends CommonPage {

    /**
     * 构造方法
     * @param d 驱动
     */
    public MovieSchedulePage(AppiumDriver d){
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement(){
        try{
            return liSchedule().get(0);
        }catch(Exception e){
            return null;
        }
    }

    /**
     * li集合 - 场次列表
     */
    public List<WebElement> liSchedule() {
        return d.findElements(By.className("con_list"));
    }

}
