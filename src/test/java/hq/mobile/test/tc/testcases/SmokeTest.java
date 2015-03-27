package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import hq.mobile.test.tc.pageobjects.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by hanqing on 2015/3/27.
 */
public class SmokeTest extends BasicTestCase {
    
    Homepage pHome;

    @Test
    public void test() {
        try{
            t.log("=== 测试开始 ===");
            pHome = new Homepage(d);
            pHome.imageViewWallet().click();
            pHome.viewSkip().click();
            pHome.imageViewOrder().click();
            pHome.imageViewMy().click();
            pHome.imageViewHome().click();
            t.takeScreenshot(d,"test","jpg");
            Thread.sleep(5000);
            t.log("=== 测试结束 ===");
        }catch (Exception e){
            t.log("Error when testing");
            e.printStackTrace();
            t.takeScreenshot(d, "error", "jpg");
            Assert.assertEquals(true, false);
        }
    }

    /**
     * 同程App
     *
     * @param searchKeyword -- 搜索关键字
     * @param uid           -- 用户名
     * @param pwd           -- 密码
     */
    @Parameters({
            "searchKeyword",
            "uid",
            "pwd"
    })
    @Test
    public void test_tc(
            String searchKeyword,
            String uid,
            String pwd) {
        try {
            t.log("启动应用");

            //等待界面出现
            Thread.sleep(5000);


            //首页，点击‘跳过’按钮
            d.findElement(By.id("com.tongcheng.android:id/iv_close")).click();

            //===== 底部导航 =====
            //发现
            t.log("底部导航");
            d.findElement(By.id("com.tongcheng.android:id/iv_home_wallet")).click();
            //发现页，点击‘跳过’按钮
            d.findElement(By.name("跳过")).click();
            //抢购
            d.findElement(By.id("com.tongcheng.android:id/iv_home_order")).click();
            //我的
            d.findElement(By.id("com.tongcheng.android:id/iv_home_my")).click();
            //点击登录链接
            t.log("登录");
            d.findElement(By.id("com.tongcheng.android:id/btn_mytc_login")).click();
            //填写登录信息并登录
            d.findElement(By.id("com.tongcheng.android:id/login_account")).sendKeys(uid);
            d.findElement(By.id("com.tongcheng.android:id/login_password")).sendKeys(pwd);
            d.findElement(By.id("com.tongcheng.android:id/login_commit_btn")).click();
            //首页
            d.findElement(By.id("com.tongcheng.android:id/iv_home_main")).click();

            //===== 首页搜索 =====
            t.log(String.format("搜索：%s", searchKeyword));
            //点击搜索框
            d.findElement(By.id("com.tongcheng.android:id/tv_home_actionbar_search")).click();
            //输入关键字
            d.findElement(By.id("com.tongcheng.android:id/keyword")).sendKeys(searchKeyword);
            //点击结果
            List<WebElement> names = d.findElements(By.id("com.tongcheng.android:id/name"));
            t.log(String.format("搜索结果数：%d", names.size()));
            List<WebElement> counts = d.findElements(By.id("com.tongcheng.android:id/count"));
            t.log(String.format("搜索结果数量数：%d", names.size()));
            for (int i = 0; i < names.size(); i++) {
                try {
                    t.log(String.format("搜索结果：%s，结果数量：%s", names.get(i).getText(), counts.get(i).getText()));
                } catch (Exception e) {
                    //do nothing
                }
            }

            //===== 点击一次搜索结果，展示二次搜索结果 =====
            t.log("点击第一个产品");
            if (names.size() > 0) {
                names.get(0).click();
            }
            //名称
            List<WebElement> names2 = d.findElements(By.id("com.tongcheng.android:id/sceneryNameTextView"));
            t.log(String.format("产品数：%d", names2.size()));
            //价格
            List<WebElement> prices2 = d.findElements(By.id("com.tongcheng.android:id/priceTextView"));
            t.log(String.format("价格数：%d", prices2.size()));
            //评分
            List<WebElement> values2 = d.findElements(By.id("com.tongcheng.android:id/ratingTextView"));
            t.log(String.format("评分数：%d", values2.size()));
            for (int i = 0; i < names2.size(); i++) {
                try {
                    t.log(String.format("名称：%s，价格：%s，评分：%s", names2.get(i).getText(), prices2.get(i).getText(), values2.get(i).getText()));
                } catch (Exception e) {
                    //do nothing
                }
            }

            //===== 点击二次搜索结果 =====
            if (names2.size() > 0) {
                names2.get(0).click();
            }

            //屏幕截图
            t.takeScreenshot(d, "testScreenshot", "jpg");
            t.log("屏幕截图完成");

            //测试结束，等待10秒
            Thread.sleep(10000);
        } catch (Exception e) {
            t.log("Error!");
            e.printStackTrace();
            Assert.assertEquals(true, false);
        }
    }
}
