package hq.mobile.test.tc.pageobjects;

import hq.mobile.test.tc.common.BasicPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hanqing on 2015/3/27.
 * TC 公共页面类 （业务相关）
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
     * WebView
     */
    public WebElement webView() {
        return d.findElementByClassName("android.webkit.WebView");
    }

    /**
     * TextView -- 标题按钮
     */
    public WebElement textViewTitle() {
        return d.findElementById("com.tongcheng.android:id/tv_actionbar_title");
    }

    /**
     * TextView -- 返回按钮
     */
    public WebElement textViewBack() {
        return d.findElementById("com.tongcheng.android:id/actionbar_back");
    }

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

    /**
     * 自检
     *
     * @return 自检是否通过
     */
    public boolean funcSelfcheck(String pageName) {
        if (!checkKeyElement) {
            t.log("不需要自检");
            return true;
        }
        t.log(String.format("执行页面 [%s] 的自检功能", pageName));
        if (keyElement() != null) {
            t.log("Pass -- 自检通过");
            funcSwitchToNativeView();
            t.takeScreenshot(d, String.format("[%s]自检通过截图", pageName), "jpg");
            return true;
        } else {
            t.log(">>>>>>>>>> 自检失败");
            t.takeScreenshot(d, String.format("[%s]自检失败截图", pageName), "jpg");
            return false;
        }
    }

    /**
     * 等待页面加载完成 -- 目前发现隐性等待对webview不起作用，所以定义这个方法
     *
     * @param sec 等待时间（秒）
     * @return 关键元素是否存在
     * @throws InterruptedException
     */
    public boolean funcWaitForKeyElement(int sec) throws InterruptedException {
        if (!checkKeyElement) {
            return true;
        }
        int i = 0;
        while ((keyElement() == null) && (i < sec)) {
            t.log("等待关键页面元素...");
            Thread.sleep(1000);
            i++;
        }
        if (i >= sec) {
            //等待超时
            t.log(">>>>>>>>>> 等待超时，无法获得关键页面元素");
            t.takeScreenshot(d, "自检失败", "jpg");
            return false;
        } else {
            return true;
        }
    }

    /**
     * 检查当前页面是否存在 WebView 控件
     *
     * @return
     */
    public boolean funcDoesWebViewExist() {
        try {
            webView();
            t.log("当前页面存在 WebView 控件");
            return true;
        } catch (Exception e) {
            t.log("当前页面不存在 WebView 控件");
            return false;
        }
    }

    /**
     * 尝试切换到 WebView
     *
     * @return 是否切换成功
     */
    public boolean funcSwitchToWebView() {
        if (!funcDoesWebViewExist()) {
            return false;
        }
        for (String viewName : d.getContextHandles()) {
            if (viewName.toLowerCase().contains("webview")) {
                d.context(viewName);
                t.log(String.format("切换到 WebView：[%s]", viewName));
                return true;
            }
        }
        t.log(">>>>>>>>>> 不存在 WebView，无法切换");
        return false;
    }

    /**
     * 尝试切换到 NativeView
     *
     * @return 是否切换成功
     */
    public boolean funcSwitchToNativeView() {
        for (String viewName : d.getContextHandles()) {
            if (viewName.toLowerCase().contains("native")) {
                d.context(viewName);
                t.log(String.format("切换到 NativeView：[%s]", viewName));
                return true;
            }
        }
        t.log(">>>>>>>>>> 不存在 NativeView，无法切换");
        return false;
    }

    /**
     * 屏幕向上滑动
     */
    public void funcSwipeUp() throws InterruptedException {
        t.log("向上滑动屏幕");
        d.swipe(100, 1000, 100, 100, 1000);
        Thread.sleep(2000);
    }
}
