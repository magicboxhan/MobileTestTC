package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import hq.mobile.test.tc.pageobjects.MyMessagePage;
import hq.mobile.test.tc.pageobjects.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by hq11258 on 2015/5/8.
 * 测试用例 -- 公共 （业务相关）
 */
public class CommonTestcase extends BasicTestCase {

    //页面对象实体
    LoadingPage pLoading;                       //加载页
    Homepage pHome;                             //首页
    SearchPage pSearch;                         //搜索页
    MyPage pMy;                                 //我的同程页
    OrderListPage pOrderList;                   //我的订单页
    LoginPage pLogin;                           //登录页
    ScenerySearchResultPage pSearchResult;      //景点 - 景点列表页
    SceneryDetailPage pSceneryDetail;           //景点 - 详情页
    SceneryWriteOrderPage pSceneryWriteOrder;   //景点 - 订单填写页
    MovieListPage pMovieList;                   //电影票 - 影片列表页
    MovieCinemaListPage pMovieCinemaList;       //电影票 - 影院列表页
    MovieSchedulePage pMovieSchedule;           //电影票 - 场次列表页
    MovieSeatSelectPage pMovieSeatSelect;       //电影票 - 选座页
    MovieWriteOrderPage pMovieWriteOrder;       //电影票 - 订单填写页
    UserInfoPage pUserInfo;                     //个人资料管理页
    SignPage pSignPage;                         //签到页
    MyMessagePage pMyMessage;                   //我的消息页
    OrderNeedPayPage pOrderNeedPay;             //待支付订单页
    OrderNeedGoPage pOrderNeedGo;               //待出行订单页
    OrderNeedCommentPage pOrderNeedComment;     //待点评订单页


    //变量
    String cityName;    //当前城市

    /**
     * 初始化变量
     *
     * @param pCityName
     */
    @Parameters({
            "cityName"
    })
    @BeforeClass
    public void beforeClass(
            String pCityName
    ) {
        cityName = pCityName;

        //初始化页面对象实体
        pLoading = new LoadingPage(d);
        pHome = new Homepage(d);
        pSearch = new SearchPage(d);
        pSearchResult = new ScenerySearchResultPage(d);
        pSceneryDetail = new SceneryDetailPage(d);
        pMy = new MyPage(d);
        pLogin = new LoginPage(d);
        pMovieList = new MovieListPage(d);
        pMovieCinemaList = new MovieCinemaListPage(d);
        pMovieSchedule = new MovieSchedulePage(d);
        pMovieSeatSelect = new MovieSeatSelectPage(d);
        pMovieWriteOrder = new MovieWriteOrderPage(d);
        pSceneryWriteOrder = new SceneryWriteOrderPage(d);
        pOrderList = new OrderListPage(d);
        pUserInfo = new UserInfoPage(d);
        pSignPage = new SignPage(d);
        pMyMessage = new MyMessagePage(d);
        pOrderNeedPay = new OrderNeedPayPage(d);
        pOrderNeedGo = new OrderNeedGoPage(d);
        pOrderNeedComment = new OrderNeedCommentPage(d);
    }

    /**
     * 进入首页
     *
     * @throws InterruptedException
     */
    public void enterHomepage() throws InterruptedException {
        t.log("=== 开始页 ===");
        t.log("滑动并进入首页");
        pLoading.funcEnterHomepage();
        //如果定位失败，则手工定位
        pHome.funcCheckLocation(cityName);
    }

    /**
     * 尝试切换到 WebView
     * @return 是否切换成功
     */
    public boolean switchToWebView(){
        for (String viewName : d.getContextHandles()) {
            if (viewName.toLowerCase().contains("webview")){
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
     * @return 是否切换成功
     */
    public boolean switchToNativeView(){
        for (String viewName : d.getContextHandles()) {
            if (viewName.toLowerCase().contains("native")){
                d.context(viewName);
                t.log(String.format("切换到 NativeView：[%s]", viewName));
                return true;
            }
        }
        t.log(">>>>>>>>>> 不存在 NativeView，无法切换");
        return false;
    }

}
