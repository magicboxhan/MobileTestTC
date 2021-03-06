package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/4/28.
 * APP加载页
 */
public class LoadingPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public LoadingPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * ImageView -- 开启快乐之旅
     */
    public WebElement imageViewEnter() {
        return d.findElementById("com.tongcheng.android:id/iv_text");
    }

    //==================== Functions ====================

    public void funcEnterHomepage() throws InterruptedException {
        //滑动4次（1次备用）
        for (int i = 0; i < 4; i++) {
            try {
                d.swipe(1000, 100, 100, 100, 1000); //大分辨率
            }catch (Exception e){
                d.swipe(720, 100, 100, 100, 1000); //小分辨率
            }
            Thread.sleep(3000);
        }

        //点击“开启快乐之旅”
        imageViewEnter().click();

    }
}
