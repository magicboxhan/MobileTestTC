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
 * 测试用例类
 */
public class SmokeTest extends CommonTestcase {

//    //页面对象实体
//    LoadingPage pLoading;
//    Homepage pHome;
//    SearchPage pSearch;
//    ScenerySearchResultPage pSearchResult;
//    SceneryDetailPage pSceneryDetail;
//    MyPage pMy;
//    LoginPage pLogin;
//    MovieCityListPage pMovieCityList;
//    MovieListPage pMovieList;
//    MovieCinemaListPage pMovieCinemaList;
//    MovieSchedulePage pMovieSchedule;
//    MovieSeatSelectPage pMovieSeatSelect;
//    MovieWriteOrderPage pMovieWriteOrder;
//    SceneryWriteOrderPage pSceneryWriteOrder;
//    OrderListPage pOrderList;
//
//    //变量
//    String cityName;    //当前城市
//
//    /**
//     * 初始化变量
//     *
//     * @param pCityName
//     */
//    @Parameters({
//            "cityName"
//    })
//    @BeforeClass
//    public void beforeClass(
//            String pCityName
//    ) {
//        cityName = pCityName;
//    }
//
//    /**
//     * 进入首页
//     *
//     * @throws InterruptedException
//     */
//    public void enterHomepage() throws InterruptedException {
//        t.log("=== 开始页 ===");
//        t.log("滑动并进入首页");
//        pLoading = new LoadingPage(d);
//        pLoading.funcEnterHomepage();
//        //如果定位失败，则手工定位
//        pHome = new Homepage(d);
//        pHome.funcCheckLocation(cityName);
//    }

    /**
     * 我的 -- 未登录状态 -- 登录
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
            t.log("");
            t.log("");
            t.log("");
            t.log("===== 登录测试 =====");
            boolean result = true;
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
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
            t.log(">>>>>>>>>> 测试出错");
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
            t.log("");
            t.log("");
            t.log("");
            t.log("===== 景点下单测试 =====");
            boolean result = true;
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
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
            pScenerySearchResult = new ScenerySearchResultPage(d);
            List<WebElement> sceneryNames = pScenerySearchResult.textViewSceneryName();
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
            t.takeScreenshot(d, String.format("[%s]", pSceneryDetail.textViewSceneryName().getText()), "jpg");
            t.log("点击预订按钮");
            pSceneryDetail.buttonOrder().get(0).click();
            t.log("=== 登录页 ===");
            pLogin = new LoginPage(d);
            pLogin.funcLogin(uid, pwd);
            t.log("=== 景点订单填写页 ===");
            pSceneryWriteOrder = new SceneryWriteOrderPage(d);
            pSceneryWriteOrder.funcSubmitOrder(getTicketName, getTicketPhone, getTicketCard, "hq11258@ly.com");
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "errorScenery", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    @Parameters({
            "uid",
            "pwd",
            "webviewName",
            "seatRow",
            "seatCol"
    })
    @Test
    public void movie(
            String uid,
            String pwd,
            String webviewName,
            int seatRow,
            int seatCol) {
        try {
            t.log("");
            t.log("");
            t.log("");
            t.log("===== 电影票下单测试 =====");
            boolean result = true;
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
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
//            t.log("=== 电影票 - 城市选择 ===");
//            for (String context : d.getContextHandles()) {
//                t.log(String.format("Context: [%s]", context));
//            }
//            t.log("切换到Webview");
//            d.context(webviewName);
//            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
//            t.log("点击第一个城市");
//            pMovieCityList = new MovieCityListPage(d);
//            try {
//                //出现城市列表才点
//                pMovieCityList.divAllCityList();
//                pMovieCityList.ddCityOfAll(0).click();
//            } catch (Exception e) {
//                //Do nothing
//            }
            t.log("=== 电影票 - 影片选择 ===");
            for (String context : d.getContextHandles()) {
                t.log(String.format("Context: [%s]", context));
            }
            t.log("切换到Webview");
            d.context(webviewName);
            t.log("点击第一个影片");
            pMovieList = new MovieListPage(d);
            Assert.assertEquals(pMovieList.funcWaitForKeyElement(BasicTestCase.WAIT_KEY_ELEMENT), true);
            pMovieList.liMovie(0).click();
            t.log("=== 电影票 - 影院选择 ===");
//            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            t.log("点击第一个影院");
            pMovieCinemaList = new MovieCinemaListPage(d);
            Assert.assertEquals(pMovieCinemaList.funcWaitForKeyElement(BasicTestCase.WAIT_KEY_ELEMENT), true);
            pMovieCinemaList.divCinema().get(0).click();
            t.log("=== 电影票 - 场次选择 ===");
//            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            t.log("点击第二个场次（如果没有，点击第一场次）");
            pMovieSchedule = new MovieSchedulePage(d);
            Assert.assertEquals(pMovieSchedule.funcWaitForKeyElement(BasicTestCase.WAIT_KEY_ELEMENT), true);
            if (pMovieSchedule.liSchedule().size() > 1) {
                //场次大于1
                pMovieSchedule.liSchedule().get(1).click();
            } else {
                //场次不大于1
                pMovieSchedule.liSchedule().get(0).click();
            }
            t.log("=== 电影票 - 座位选择 ===");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
            pMovieSeatSelect = new MovieSeatSelectPage(d);
            switch (pMovieSeatSelect.funcGetPageType()) {
                case 1:
                    t.log("=== 带 选好了 按钮的页面 ===");
                    t.log("点击第一行的第一个可用座位");
                    pMovieSeatSelect.funcSelectSeat(seatRow, seatCol);
                    break;
                case 2:
                    t.log("=== 不带 选好了 按钮的页面 ===");
                    t.log("点击第一行的第一个可用座位");
                    pMovieSeatSelect.funcSelectSeat(seatRow, seatCol);
                    t.log("=== 电影票 - 订单填写 ===");
                    Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
                    pMovieWriteOrder = new MovieWriteOrderPage(d);
                    t.log("点击提交订单");
                    pMovieWriteOrder.aSubmitOrder().click();
                    break;
                default:
                    t.log(">>>>>>>>>> 出错 -- 未知页面");
                    Assert.assertEquals(false, true);
                    break;
            }
            Thread.sleep(10000);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
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
            t.log("===== 取消删除所有订单 =====");
            boolean result = true;
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
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
            t.log("=== 订单列表页 ===");
            Assert.assertEquals(pOrderList.funcSelfcheck("订单列表页"), true);
            t.log("取消并删除全部订单");
            pOrderList = new OrderListPage(d);
            d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); //调整隐性等待时间，加速订单取消速度
            pOrderList.funcCancelDeleteAllOrders();
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            Assert.assertEquals(pOrderList.funcSelfcheck("订单列表页"), true);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "errorCancelDeleteAllOrders", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    @Test
    public void failedDemo() {
        Assert.assertEquals(false, true);
    }

}
