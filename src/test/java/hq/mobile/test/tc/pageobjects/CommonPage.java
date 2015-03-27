package hq.mobile.test.tc.pageobjects;

import hq.mobile.test.tc.common.BasicPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hanqing on 2015/3/27.
 * TC公共页面类 *
 */
public class CommonPage extends BasicPage {

    public CommonPage(AppiumDriver d){
        super(d);
    }
    
    //==================== Elements ====================

    /**
     * 底部导航 -- 首页 * 
     * @return
     */
    public WebElement imageViewHome(){
        return d.findElementById("com.tongcheng.android:id/iv_home_main");
    }

    /**
     * 底部导航 -- 发现 *
     * @return
     */
    public WebElement imageViewWallet(){
        return d.findElementById("com.tongcheng.android:id/iv_home_wallet");
    }

    /**
     * 底部导航 -- 抢购 *
     * @return
     */
    public WebElement imageViewOrder(){
        return d.findElementById("com.tongcheng.android:id/iv_home_order");
    }

    /**
     * 底部导航 -- 我的 *
     * @return
     */
    public WebElement imageViewMy(){
        return d.findElementById("com.tongcheng.android:id/iv_home_my");
    }

    /**
     * 底部导航 -- 我的 *
     * @return
     */
    public WebElement viewSkip(){
        return d.findElementByName("跳过");
    }






    //==================== Functions ====================
    
}
