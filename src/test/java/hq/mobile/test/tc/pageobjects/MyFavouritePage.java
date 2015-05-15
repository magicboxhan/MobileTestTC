package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/15.
 * 我的收藏页
 */
public class MyFavouritePage extends CommonPage {

    public MyFavouritePage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewJiuDianShouCang();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView -- 酒店收藏
     */
    public WebElement textViewJiuDianShouCang() {
        return d.findElementByName("酒店收藏");
    }

    /**
     * TextView -- 景点门票收藏
     */
    public WebElement textViewJingDianMenPiaoShouCang() {
        return d.findElementByName("景点门票收藏");
    }

    /**
     * TextView -- 周边游收藏
     */
    public WebElement textViewZhouBianYouShouCang() {
        return d.findElementByName("周边游收藏");
    }

    /**
     * TextView -- 出境邮轮收藏(离线攻略)
     */
    public WebElement textViewChuJingYouLunShouCang() {
        return d.findElementByName("出境邮轮收藏(离线攻略)");
    }

    /**
     * TextView -- 攻略收藏
     */
    public WebElement textViewGongLueShouCang() {
        return d.findElementByName("攻略收藏");
    }

    /**
     * TextView -- 发现收藏
     */
    public WebElement textViewFaXianShouCang() {
        return d.findElementByName("发现收藏");
    }
}
