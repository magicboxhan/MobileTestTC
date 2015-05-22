package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/22.
 * 周边游详情页
 */
public class TravelDetailPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public TravelDetailPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewBook();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 查看套餐
     */
    public WebElement textViewBook() {
        return d.findElementById("com.tongcheng.android:id/btn_book");
    }
}
