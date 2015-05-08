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

    /**
     * 自检
     * @return 自检是否通过
     */
    public boolean funcSelfcheck(String pageName) {
        if (!checkKeyElement) {
            t.log("不需要自检");
            return true;
        }
        t.log(String.format("执行页面 [%s] 的自检功能", pageName));
        if (keyElement() != null) {
            t.log("自检通过");
            return true;
        }else{
            t.log("自检失败");
            return false;
        }
    }

    /**
     * 等待页面加载完成 -- 目前发现隐性等待对webview不起作用，所以定义这个方法
     *
     * @param sec 等待时间（秒）
     * @return 关键元素是否存在
     * @throws InterruptedException
     */
    public boolean funcWaitForKeyElement(int sec) throws InterruptedException {
        if (!checkKeyElement) {
            return true;
        }
        int i = 0;
        while ((keyElement() == null) && (i < sec)) {
            t.log("等待关键页面元素...");
            Thread.sleep(1000);
            i++;
        }
        if (i >= sec) {
            //等待超时
            t.log(">>>>>>>>>> 等待超时，无法获得关键页面元素");
            t.takeScreenshot(d, "自检失败", "jpg");
            return false;
        } else {
            return true;
        }
    }

}
