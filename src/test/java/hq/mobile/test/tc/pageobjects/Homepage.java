﻿package hq.mobile.test.tc.pageobjects;

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
    }

    //==================== Elements ====================

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
     * ImageView -- 容器（根据索引）
     *
     * @param index 索引
     */
    public WebElement imageViewContainer(int index) {
        try {
            return d.findElementsById("com.tongcheng.android:id/iv_container_item").get(index);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ImageView -- 功能（根据索引）
     *
     * @param index 索引
     */
    public WebElement imageViewFeature(int index) {
        try {
            return d.findElementsById("com.tongcheng.android:id/iv_feature_item").get(index);
        } catch (Exception e) {
            return null;
        }
    }


    //==================== Functions ====================


}
