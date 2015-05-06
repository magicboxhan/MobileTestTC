package hq.mobile.test.tc.pageobjects;

import hq.mobile.test.tc.common.BasicPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hanqing on 2015/3/27.
 * TC 公共页面类
 */
public class CommonPage extends BasicPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public CommonPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * 底部导航 -- 首页
     */
    public WebElement imageViewHome() {
        return d.findElementById("com.tongcheng.android:id/iv_home_main");
    }

    /**
     * 底部导航 -- 发现
     */
    public WebElement imageViewWallet() {
        return d.findElementById("com.tongcheng.android:id/iv_home_wallet");
    }

    /**
     * 底部导航 -- 抢购
     */
    public WebElement imageViewOrder() {
        return d.findElementById("com.tongcheng.android:id/iv_home_order");
    }

    /**
     * 底部导航 -- 我的
     */
    public WebElement imageViewMy() {
        return d.findElementById("com.tongcheng.android:id/iv_home_my");
    }

    /**
     * 按钮 -- 跳过
     */
    public WebElement viewSkip() {
        return d.findElementByName("跳过");
    }

    /**
     * View -- 日历表格（按月份分）
     */
    public List<WebElement> viewCalendarGrid() {
        return d.findElementsById("com.tongcheng.android:id/calendar_grid");
    }

    /**
     * TextView -- 按照索引返回日历中的日期
     *
     * @param month 要选择的日历中的月份索引（从0开始）
     * @param week  要选择的日历中的周索引（从0开始）
     * @param day   要选择的日历中的日期索引（从0开始）
     */
    public WebElement textViewCalendarCell(int month, int week, int day) {
        return viewCalendarGrid().get(month).findElements(By.className("android.view.View")).get(week + 1).findElements(By.className("android.widget.TextView")).get(day);
    }







    //==================== Functions ====================
}
