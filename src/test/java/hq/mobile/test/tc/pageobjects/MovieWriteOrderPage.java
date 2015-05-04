package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/4/30.
 */
public class MovieWriteOrderPage extends CommonPage {

    /**
     * 构造方法
     * @param d 驱动
     */
    public MovieWriteOrderPage(AppiumDriver d){
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement(){
        try{
            return aSubmitOrder();
        }catch(Exception e){
            return null;
        }
    }

    /**
     * a - 提交订单
     */
    public WebElement aSubmitOrder() {
        return d.findElement(By.id("paymentbtn"));
    }
}
