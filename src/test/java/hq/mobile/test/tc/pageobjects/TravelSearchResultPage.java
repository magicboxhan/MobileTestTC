package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/5/22.
 * 周边游搜索结果页
 */
public class TravelSearchResultPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public TravelSearchResultPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewTravelName().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView集合 -- 周边游线路名称
     */
    public List<WebElement> textViewTravelName() {
        return d.findElementsById("com.tongcheng.android:id/tv_travel_name");
    }

}
