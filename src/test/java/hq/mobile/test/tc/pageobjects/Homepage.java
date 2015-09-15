package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hanqing on 2015/3/27.
 * 首页
 */
public class Homepage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public Homepage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewCity();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 搜索
     */
    public WebElement textViewSearch() {
        return d.findElementById("com.tongcheng.android:id/tv_home_actionbar_search");
    }

    /**
     * TextView -- 城市
     */
    public WebElement textViewCity() {
        return d.findElementById("com.tongcheng.android:id/tv_home_actionbar_city");
    }

    /**
     * TextView -- 电话
     */
    public WebElement textViewTel() {
        return d.findElementById("com.tongcheng.android:id/iv_home_actionbar_tel");
    }

    /**
     * ImageView -- 模块（根据索引）
     *
     * @param index 索引
     */
    public WebElement imageViewModule(int index) {
        try {
            return d.findElementsById("com.tongcheng.android:id/iv_module").get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ImageView -- 项目（根据索引）
     *
     * @param index 索引
     */
    public WebElement imageViewProject(int index) {
        try {
            return d.findElementsById("com.tongcheng.android:id/tv_project_name").get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ImageView -- 操作（根据索引）
     *
     * @param index 索引
     */
    public WebElement imageViewOperation(int index) {
        try {
            return d.findElementsById("com.tongcheng.android:id/iv_operation_icon").get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ImageView - 周边游
     */
    public WebElement imageViewTravel() {
        return imageViewModule(0);
    }

    /**
     * ImageView - 景区
     */
    public WebElement imageViewScenery() {
        return imageViewModule(4);
    }

    /**
     * ImageView - 酒店
     */
    public WebElement imageViewHotel() {
        return imageViewModule(5);
    }

    /**
     * ImageView - 电影票
     */
    public WebElement imageViewMovie() {
        return imageViewProject(2);
    }


    //==================== Functions ====================

    /**
     * 检查是否定位成功，如果没有，则手工指定城市
     */
    public void funcCheckLocation(String name) {
        if (textViewCity().getText().contains("全国")) {
            //表示没有定位成功，需要手工指定城市
            t.log("自动定位失败，将人工选择城市");
            textViewCity().click();
            d.findElementByName(name).click();
        }
    }

}
