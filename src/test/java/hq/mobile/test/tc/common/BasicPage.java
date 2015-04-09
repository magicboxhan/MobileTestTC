package hq.mobile.test.tc.common;

import io.appium.java_client.AppiumDriver;

/**
 * Created by hanqing on 2015/3/27.
 * 框架基类
 */
public class BasicPage {

    protected Tools t = new Tools();
    protected AppiumDriver d;

    /**
     * 构造方法
     * @param driver 驱动
     */
    public BasicPage(AppiumDriver driver){
        d = driver;
    }
    
}
