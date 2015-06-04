package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hanqing on 2015/3/30.
 * 景点详情页
 */
public class SceneryDetailPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public SceneryDetailPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return textViewSceneryName();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Button集合 -- 预订
     */
    public List<WebElement> buttonOrder() {
        return d.findElementsById("com.tongcheng.android:id/ll_book");
    }

    /**
     * TextView -- 景点名称
     */
    public WebElement textViewSceneryName() {
        return d.findElementById("com.tongcheng.android:id/tv_scenery_name");
    }

    /**
     * TextView -- 景点评论数
     */
    public WebElement textViewCommentCount() {
        return d.findElementById("com.tongcheng.android:id/commentCount");
    }

    /**
     * TextView -- 点评
     */
    public WebElement textViewComment() {
        return d.findElementById("com.tongcheng.android:id/comment");
    }

    /**
     * TextView -- 图片
     */
    public WebElement textViewPicture() {
        return d.findElementById("com.tongcheng.android:id/picture");
    }

    /**
     * TextView -- 周边
     */
    public WebElement textViewNear() {
        return d.findElementById("com.tongcheng.android:id/near");
    }

    /**
     * TextView -- 简介
     */
    public WebElement textViewDes() {
        return d.findElementById("com.tongcheng.android:id/des");
    }

    /**
     * TextView -- 地址
     */
    public WebElement textViewAddress() {
        return d.findElementById("com.tongcheng.android:id/address");
    }

    /**
     * TextView -- 票名
     */
    public WebElement textViewGroupName() {
        return d.findElementById("com.tongcheng.android:id/groupName");
    }

    /**
     * TextView -- 票价
     */
    public WebElement textViewGroupPrice() {
        return d.findElementById("com.tongcheng.android:id/groupPrice");
    }

    //==================== Functions ====================

    /**
     * 点击组合优惠票
     * @throws InterruptedException
     */
    public void funcClickZuHeYouHuiPiao() throws InterruptedException {
        if(funcSwipeUpUntilElementShowUp("组合优惠票")){
            d.findElementByName("组合优惠票").click();
        }
    }

    /**
     * 点击联票预定按钮
     * @throws InterruptedException
     */
    public void funcClickLianPiao() throws InterruptedException {
        if(funcSwipeUpUntilElementShowUp("惠")){
            for(WebElement ll : d.findElementsByClassName("android.widget.LinearLayout")){
                //遍历页面上的LL，每个代表一个票型
                if(ll.findElements(By.name("惠")).size() > 0){
                    ll.findElement(By.id("com.tongcheng.android:id/ll_book")).click();
                    return;
                }
            }
        }
    }

}
