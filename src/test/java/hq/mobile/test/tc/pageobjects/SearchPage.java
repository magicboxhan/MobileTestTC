package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hanqing on 2015/3/27.
 * 搜索页
 */
public class SearchPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public SearchPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * ImageView -- 后退
     */
    public WebElement imageViewBack() {
        return d.findElementById("com.tongcheng.android:id/actionbar_back");
    }

    /**
     * EditText -- 搜索关键字
     */
    public WebElement editTextKeyword() {
        return d.findElementById("com.tongcheng.android:id/keyword");
    }

    /**
     * TextView -- 关键字名称集合
     */
    public List<WebElement> textViewNames() {
        return d.findElementsById("com.tongcheng.android:id/name");
    }

    /**
     * TextView -- 关键字名称（根据索引）
     *
     * @param index 索引
     */
    public WebElement textViewName(int index) {
        try {
            return textViewNames().get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 关键字结果数量集合
     */
    public List<WebElement> textViewCounts() {
        return d.findElementsById("com.tongcheng.android:id/count");
    }

    /**
     * TextView -- 关键字结果数量（根据索引）
     *
     * @param index 索引
     */
    public WebElement textViewCount(int index) {
        try {
            return textViewCounts().get(index);
        } catch (Exception e) {
            return null;
        }
    }

    //==================== Functions ====================


}
