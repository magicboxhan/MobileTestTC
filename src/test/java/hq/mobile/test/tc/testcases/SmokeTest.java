package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import hq.mobile.test.tc.pageobjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hanqing on 2015/3/27.
 */
public class SmokeTest extends BasicTestCase {

    LoadingPage pLoading;
    Homepage pHome;
    SearchPage pSearch;
    ScenerySearchResultPage pSearchResult;
    SceneryDetailPage pSceneryDetail;
    MyPage pMy;
    LoginPage pLogin;
    MovieCityListPage pMovieCityList;
    MovieListPage pMovieList;
    MovieCinemaListPage pMovieCinemaList;
    MovieSchedulePage pMovieSchedule;
    MovieSeatSelectPage pMovieSeatSelect;
    MovieWriteOrderPage pMovieWriteOrder;
    SceneryWriteOrderPage pSceneryWriteOrder;
    OrderListPage pOrderList;

    public void enterHomepage() throws InterruptedException {
        t.log("=== 开始页 ===");
        t.log("滑动并进入首页");
        pLoading = new LoadingPage(d);
        pLoading.funcEnterHomepage();
    }

    /**
     * 登录验证脚本
     *
     * @param uid 用户名
     * @param pwd 密码
     */
    @Parameters({
            "uid",
            "pwd"
    })
    @Test
    public void login(String uid, String pwd) {
        try {
            boolean result = true;
            Thread.sleep(5000);
            enterHomepage();
            t.log("=== 首页 ===");
            t.log("点击“我的”");
            pHome = new Homepage(d);
            pHome.imageViewMy().click();
            t.log("=== 我的 ===");
            t.log("点击登录");
            pMy = new MyPage(d);
            pMy.textViewLogin().click();
            t.log("=== 登录页 ===");
            t.log(String.format("输入用户名：[%s]，密码：[%s]", uid, pwd));
            pLogin = new LoginPage(d);
            t.log("点击登录按钮");
            pLogin.funcLogin(uid, pwd);
            t.log("=== 我的 ===");
            t.log("验证登录");
            result &= pMy.funcVerifyLoginResult();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log("=== 测试出错 ===");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "errorLogin", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 景区下单脚本
     *
     * @param searchKeyword 搜索关键字
     */
    @Parameters({
            "searchKeyword",
            "keywordIndex",
            "sceneryIndex",
            "uid",
            "pwd",
            "getTicketName",
            "getTicketPhone",
            "getTicketCard",
            "month",
            "week",
            "day"
    })
    @Test
    public void scenery(
            String searchKeyword,
            int keywordIndex,
            int sceneryIndex,
            String uid,
            String pwd,
            String getTicketName,
            String getTicketPhone,
            String getTicketCard,
            int month,
            int week,
            int day) {
        try {
            boolean result = true;
            Thread.sleep(5000);
            enterHomepage();
            t.log("=== 首页 ===");
            t.log("点击搜索框");
            pHome = new Homepage(d);
            pHome.textViewSearch().click();
            t.log("=== 搜索页 ===");
            t.log(String.format("输入搜索关键字：%s", searchKeyword));
            pSearch = new SearchPage(d);
            pSearch.editTextKeyword().clear();
            pSearch.editTextKeyword().sendKeys(searchKeyword);
            List<WebElement> eKeywords = pSearch.textViewSearchContents();
            int resultCount = eKeywords.size();
            t.log(String.format("共搜索到%s个关键字：", resultCount));
            t.log(String.format("点击第%s个关键字", keywordIndex));
            eKeywords.get(keywordIndex).click();
            t.log("=== 搜索结果页 ===");
            pSearchResult = new ScenerySearchResultPage(d);
            List<WebElement> sceneryNames = pSearchResult.textViewSceneryNames();
            int sceneryCount = sceneryNames.size();
            t.log(String.format("共搜索到%d个景点（页面展示）", sceneryCount));
//            for (int i = 0; i < sceneryCount; i++) {
//                if (pSearchResult.textViewSceneryName(i) == null) {
//                    continue;
//                }
//                String name = pSearchResult.textViewSceneryName(i).getText();
//                String rate;
//                if (pSearchResult.textViewSceneryRate(i) != null) {
//                    rate = pSearchResult.textViewSceneryRate(i).getText();
//                } else {
//                    rate = "";
//                }
//                String price;
//                if (pSearchResult.textViewSceneryPrice(i) != null) {
//                    price = pSearchResult.textViewSceneryPrice(i).getText();
//                } else {
//                    price = "";
//                }
//                t.log(String.format("景点名称：[%s]，景点评分：[%s]，景点价格：[%s]", name, rate, price));
//            }
            t.log(String.format("点击第%s个景点", sceneryIndex));
            sceneryNames.get(sceneryIndex).click();
            t.log("=== 景点详情页 ===");
            pSceneryDetail = new SceneryDetailPage(d);
            t.log(String.format("景点名称：[%s]", pSceneryDetail.textViewSceneryName().getText()));
            t.log(String.format("景点评论数：[%s]", pSceneryDetail.textViewCommentCount().getText()));
            t.log(String.format("景点名称景点地址：[%s]", pSceneryDetail.textViewAddress().getText()));
            t.log(String.format("景点门票类型：[%s]", pSceneryDetail.textViewGroupName().getText()));
            t.log(String.format("景点门票价格：[%s]", pSceneryDetail.textViewGroupPrice().getText()));
            t.takeScreenshot(d, String.format("[%s]景点详情截图", pSceneryDetail.textViewSceneryName().getText()), "jpg");
            t.log("点击预订按钮");
            pSceneryDetail.buttonOrder().click();
            t.log("=== 登录页 ===");
            pLogin = new LoginPage(d);
            pLogin.funcLogin(uid, pwd);
            t.log("=== 景点订单填写页 ===");
            pSceneryWriteOrder = new SceneryWriteOrderPage(d);
            pSceneryWriteOrder.funcSubmitOrder(getTicketName, getTicketPhone, getTicketCard, month, week, day);
            Assert.assertEquals(true, true);
        } catch (Exception e) {
            t.log("=== 测试出错 ===");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "errorScenery", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    @Parameters({
            "uid",
            "pwd",
            "webviewName"
    })
    @Test
    public void movie(
            String uid,
            String pwd,
            String webviewName) {
        try {
            boolean result = true;
            Thread.sleep(5000);
            enterHomepage();
            t.log("=== 首页 ===");
            t.log("点击“我的”");
            pHome = new Homepage(d);
            pHome.imageViewMy().click();
            t.log("=== 我的 ===");
            t.log("点击登录");
            pMy = new MyPage(d);
            pMy.textViewLogin().click();
            t.log("=== 登录页 ===");
            t.log(String.format("输入用户名：[%s]，密码：[%s]，并登录", uid, pwd));
            pLogin = new LoginPage(d);
            pLogin.funcLogin(uid, pwd);
            t.log("=== 我的 ===");
            t.log("点击首页");
            pMy.imageViewHome().click();
            t.log("=== 首页 ===");
            t.log("点击“电影票”");
            pHome = new Homepage(d);
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT); //避免由于广告导致的元素位移
            pHome.imageViewMovie().click();
            t.log("=== 电影票 - 城市选择 ===");
            for (String context : d.getContextHandles()) {
                t.log(String.format("Context: [%s]", context));
            }
            t.log("切换到Webview");
            d.context(webviewName);
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT); //等待页面加载
            t.log("点击第一个城市");
            pMovieCityList = new MovieCityListPage(d);
            try {
                //出现城市列表才点
                pMovieCityList.divAllCityList();
                pMovieCityList.ddCityOfAll(0).click();
            }catch(Exception e){
                //Do nothing
            }
            t.log("=== 电影票 - 影片选择 ===");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            t.log("点击第一个影片");
            pMovieList = new MovieListPage(d);
            pMovieList.liMovie(0).click();
            t.log("=== 电影票 - 影院选择 ===");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            t.log("点击第一个影院");
            pMovieCinemaList = new MovieCinemaListPage(d);
            pMovieCinemaList.divCinema().get(0).click();
            t.log("=== 电影票 - 场次选择 ===");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            t.log("点击第二个场次");
            pMovieSchedule = new MovieSchedulePage(d);
            pMovieSchedule.liSchedule().get(1).click();
            t.log("=== 电影票 - 座位选择 ===");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            t.log("点击第一行的第一个可用座位");
            pMovieSeatSelect = new MovieSeatSelectPage(d);
            pMovieSeatSelect.funcSelectSeat(0, 0);
            t.log("=== 电影票 - 订单填写 ===");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            pMovieWriteOrder = new MovieWriteOrderPage(d);
            t.log("点击提交订单");
            pMovieWriteOrder.aSubmitOrder().click();
            Thread.sleep(10000);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log("=== 测试出错 ===");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "errorMovie", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 取消删除所有订单
     *
     * @param uid 用户名
     * @param pwd 密码
     */
    @Parameters({
            "uid",
            "pwd"
    })
    @Test
    public void cancelDeleteAllOrders(String uid, String pwd) {
        try {
            boolean result = true;
            Thread.sleep(5000);
            enterHomepage();
            t.log("=== 首页 ===");
            t.log("点击“我的”");
            pHome = new Homepage(d);
            pHome.imageViewMy().click();
            t.log("=== 我的 ===");
            t.log("点击登录");
            pMy = new MyPage(d);
            pMy.textViewLogin().click();
            t.log("=== 登录页 ===");
            t.log(String.format("输入用户名：[%s]，密码：[%s]", uid, pwd));
            pLogin = new LoginPage(d);
            t.log("点击登录按钮");
            pLogin.funcLogin(uid, pwd);
            t.log("=== 我的 ===");
            t.log("验证登录");
            result &= pMy.funcVerifyLoginResult();
            Assert.assertEquals(true, result);
            t.log("点击全部订单");
            pMy.textViewAllOrder().click();
            t.log("=== 订单列表 ===");
            t.log("取消并删除全部订单");
            pOrderList = new OrderListPage(d);
            d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            pOrderList.funcCancelDeleteAllOrders();
            Thread.sleep(5000);
            Assert.assertEquals(true, true);
        } catch (Exception e) {
            t.log("=== 测试出错 ===");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "error_cancelDeleteAllOrders", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    @Test
    public void failedDemo() {
        Assert.assertEquals(true, false);
    }

//    /**
//     * 同程App
//     *
//     * @param searchKeyword -- 搜索关键字
//     * @param uid           -- 用户名
//     * @param pwd           -- 密码
//     */
//    @Parameters({
//            "searchKeyword",
//            "uid",
//            "pwd"
//    })
//    @Test
//    public void test_tc(
//            String searchKeyword,
//            String uid,
//            String pwd) {
//        try {
//            t.log("启动应用");
//
//            //等待界面出现
//            Thread.sleep(5000);
//
//
//            //首页，点击‘跳过’按钮
//            d.findElement(By.id("com.tongcheng.android:id/iv_close")).click();
//
//            //===== 底部导航 =====
//            //发现
//            t.log("底部导航");
//            d.findElement(By.id("com.tongcheng.android:id/iv_home_wallet")).click();
//            //发现页，点击‘跳过’按钮
//            d.findElement(By.name("跳过")).click();
//            //抢购
//            d.findElement(By.id("com.tongcheng.android:id/iv_home_order")).click();
//            //我的
//            d.findElement(By.id("com.tongcheng.android:id/iv_home_my")).click();
//            //点击登录链接
//            t.log("登录");
//            d.findElement(By.id("com.tongcheng.android:id/btn_mytc_login")).click();
//            //填写登录信息并登录
//            d.findElement(By.id("com.tongcheng.android:id/login_account")).sendKeys(uid);
//            d.findElement(By.id("com.tongcheng.android:id/login_password")).sendKeys(pwd);
//            d.findElement(By.id("com.tongcheng.android:id/login_commit_btn")).click();
//            //首页
//            d.findElement(By.id("com.tongcheng.android:id/iv_home_main")).click();
//
//            //===== 首页搜索 =====
//            t.log(String.format("搜索：%s", searchKeyword));
//            //点击搜索框
//            d.findElement(By.id("com.tongcheng.android:id/tv_home_actionbar_search")).click();
//            //输入关键字
//            d.findElement(By.id("com.tongcheng.android:id/keyword")).sendKeys(searchKeyword);
//            //点击结果
//            List<WebElement> names = d.findElements(By.id("com.tongcheng.android:id/name"));
//            t.log(String.format("搜索结果数：%d", names.size()));
//            List<WebElement> counts = d.findElements(By.id("com.tongcheng.android:id/count"));
//            t.log(String.format("搜索结果数量数：%d", names.size()));
//            for (int i = 0; i < names.size(); i++) {
//                try {
//                    t.log(String.format("搜索结果：%s，结果数量：%s", names.get(i).getText(), counts.get(i).getText()));
//                } catch (Exception e) {
//                    //do nothing
//                }
//            }
//
//            //===== 点击一次搜索结果，展示二次搜索结果 =====
//            t.log("点击第一个产品");
//            if (names.size() > 0) {
//                names.get(0).click();
//            }
//            //名称
//            List<WebElement> names2 = d.findElements(By.id("com.tongcheng.android:id/sceneryNameTextView"));
//            t.log(String.format("产品数：%d", names2.size()));
//            //价格
//            List<WebElement> prices2 = d.findElements(By.id("com.tongcheng.android:id/priceTextView"));
//            t.log(String.format("价格数：%d", prices2.size()));
//            //评分
//            List<WebElement> values2 = d.findElements(By.id("com.tongcheng.android:id/ratingTextView"));
//            t.log(String.format("评分数：%d", values2.size()));
//            for (int i = 0; i < names2.size(); i++) {
//                try {
//                    t.log(String.format("名称：%s，价格：%s，评分：%s", names2.get(i).getText(), prices2.get(i).getText(), values2.get(i).getText()));
//                } catch (Exception e) {
//                    //do nothing
//                }
//            }
//
//            //===== 点击二次搜索结果 =====
//            if (names2.size() > 0) {
//                names2.get(0).click();
//            }
//
//            //屏幕截图
//            t.takeScreenshot(d, "testScreenshot", "jpg");
//            t.log("屏幕截图完成");
//
//            //测试结束，等待10秒
//            Thread.sleep(10000);
//        } catch (Exception e) {
//            t.log("Error!");
//            e.printStackTrace();
//            Assert.assertEquals(true, false);
//        }
//    }
}
