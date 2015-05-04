package hq.mobile.test.tc.common;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hanqing on 2015/3/27.
 * 框架基类
 */
public class BasicPage {

    protected Tools t = new Tools();
    protected AppiumDriver d;
    protected boolean checkKeyElement = false;

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
    public WebElement keyElement(){
        //定义页面关键元素的获取方法
        return null;
    }

    //==================== Functions ====================

    /**
     * 等待页面加载完成 -- 目前发现隐性等待对webview不起作用，所以定义这个方法
     * @param sec 等待时间（秒）
     * @return WebView关键元素是否存在
     * @throws InterruptedException
     */
    public boolean funcWaitForKeyElement(int sec) throws InterruptedException {
        if (!checkKeyElement){
            return true;
        }
        int i = 0;
        while ((keyElement() == null) && (i < sec)){
            t.log("Waiting for WebView key element...");
            Thread.sleep(1000);
            i++;
        }
        if (i >= sec){
            //等待超时
            t.log(">>>>>>>>>> Wait timeout. Can not find key element on WebView");
            t.takeScreenshot(d, "checkKeyElement", "jpg");
            return false;
        }else{
            return true;
        }
    }

}
