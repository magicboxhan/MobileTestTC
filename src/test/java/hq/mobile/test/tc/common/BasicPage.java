package hq.mobile.test.tc.common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hanqing on 2015/3/27.
 * 框架基类 （业务无关）
 */
public class BasicPage {

    protected Tools t = new Tools();
    protected AppiumDriver d;
    protected boolean checkKeyElement = false;  //是否需要检查关键元素

    /**
     * 构造方法
     *
     * @param driver 驱动
     */
    public BasicPage(AppiumDriver driver) {
        d = driver;
    }

    //==================== Elements ====================

    /**
     * 定义页面关键元素的获取方法，用于被等待方法调用
     */
    public WebElement keyElement() {
        //定义页面关键元素的获取方法
        return null;
    }

    //==================== Functions ====================


}
