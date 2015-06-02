package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hanqing on 2015/3/27.
 * 搜索结果页
 */
public class ScenerySearchResultPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public ScenerySearchResultPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewSceneryName().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView集合 -- 景区名称
     */
    public List<WebElement> textViewSceneryName() {
        return d.findElementsById("com.tongcheng.android:id/sceneryNameTextView");
    }

    /**
     * ImageView -- 后退
     */
    public WebElement imageViewBack() {
        return d.findElementById("com.tongcheng.android:id/actionbar_back");
    }

    /**
     * EditText -- 搜索关键字
     */
    public WebElement EditTextKeyword() {
        return d.findElementById("com.tongcheng.android:id/et_content");
    }

    /**
     * ImageView -- 右上角按钮
     */
    public WebElement imageViewMenuItem() {
        return d.findElementById("com.tongcheng.android:id/iv_actionbar_menu_item");
    }

    /**
     * TextView -- 景点名称（根据索引）（点击搜索后出现）
     *
     * @param index 索引
     */
    public WebElement textViewName(int index) {
        try {
            return d.findElementsById("com.tongcheng.android:id/sceneryNameTextView").get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 景点所在城市（根据索引）（点击搜索后出现）
     *
     * @param index 索引
     */
    public WebElement textViewCity(int index) {
        try {
            return d.findElementsById("com.tongcheng.android:id/sceneryCityTextView").get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 排序（根据索引）
     *
     * @param index 索引
     */
    public WebElement textViewSort(int index) {
        try {
            return d.findElementsById("com.tongcheng.android:id/textView1").get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ListView -- 搜索结果列表
     */
    public WebElement listViewSceneryList() {
        return d.findElementById("com.tongcheng.android:id/lv_scenery_list");
    }

    /**
     * TextView -- 景点名称（根据索引）
     *
     * @param index 索引
     */
    public WebElement textViewSceneryName(int index) {
        try {
            return textViewSceneryName().get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 景点评分集合
     */
    public List<WebElement> textViewSceneryRates() {
        return d.findElementsById("com.tongcheng.android:id/ratingTextView");
    }

    /**
     * TextView -- 景点评分（根据索引）
     *
     * @param index 索引
     */
    public WebElement textViewSceneryRate(int index) {
        try {
            return textViewSceneryRates().get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 景点价格集合
     */
    public List<WebElement> textViewSceneryPrice() {
        return d.findElementsById("com.tongcheng.android:id/priceTextView");
    }

    /**
     * TextView -- 景点价格（根据索引）
     *
     * @param index 索引
     */
    public WebElement textViewSceneryPrice(int index) {
        try {
            return textViewSceneryPrice().get(index);
        } catch (Exception e) {
            return null;
        }
    }


    //==================== Functions ====================

}
