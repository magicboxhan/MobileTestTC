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
    LoadingPage pLoading;                                           //加载页
    Homepage pHome;                                                 //首页
    SearchPage pSearch;                                             //搜索页
    MyPage pMy;                                                     //我的同程页
    OrderListPage pOrderList;                                       //我的订单页
    LoginPage pLogin;                                               //登录页
    ScenerySearchResultPage pSearchResult;                          //景点 - 景点列表页
    SceneryDetailPage pSceneryDetail;                               //景点 - 详情页
    SceneryWriteOrderPage pSceneryWriteOrder;                       //景点 - 订单填写页
    MovieListPage pMovieList;                                       //电影票 - 影片列表页
    MovieCinemaListPage pMovieCinemaList;                           //电影票 - 影院列表页
    MovieSchedulePage pMovieSchedule;                               //电影票 - 场次列表页
    MovieSeatSelectPage pMovieSeatSelect;                           //电影票 - 选座页
    MovieWriteOrderPage pMovieWriteOrder;                           //电影票 - 订单填写页
    UserInfoPage pUserInfo;                                         //个人资料管理页
    SignPage pSignPage;                                             //签到页
    MyMessagePage pMyMessage;                                       //我的消息页
    OrderNeedPayPage pOrderNeedPay;                                 //待支付订单页
    OrderNeedGoPage pOrderNeedGo;                                   //待出行订单页
    OrderNeedCommentPage pOrderNeedComment;                         //待点评订单页
    MyWealthPage pMyWealth;                                         //我的同程 - 我的财富页
    MyJiangJinZhangHuPage pMyJiangJinZhangHu;                       //我的财富 - 奖金账户页
    MyLiFanZhangHuPage pMyLiFanZhangHu;                             //我的财富 - 立返账户页
    MyDiXianHongBaoPage pMyDiXianHongBao;                           //我的财富 - 抵现红包
    MyFanXianHongBaoPage pMyFanXianHongBao;                         //我的财富 - 返现红包
    MyCardPage pMyCard;                                             //我的同程 - 我的卡券页
    MyDianZiPiaoPage pMyDianZiPiao;                                 //我的卡券 - 电子票
    MyZhouMoKaPage pMyZhouMoKa;                                     //我的卡券 - 周末卡
    MyAiLvKaPage pMyAiLvKa;                                         //我的卡券 - 爱旅卡
    MyYouPiaoKaPage pMyYouPiaoKa;                                   //我的卡券 - 有票卡


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
        pMyWealth = new MyWealthPage(d);
        pMyJiangJinZhangHu = new MyJiangJinZhangHuPage(d);
        pMyLiFanZhangHu = new MyLiFanZhangHuPage(d);
        pMyDiXianHongBao = new MyDiXianHongBaoPage(d);
        pMyFanXianHongBao = new MyFanXianHongBaoPage(d);
        pMyCard = new MyCardPage(d);
        pMyDianZiPiao = new MyDianZiPiaoPage(d);
        pMyZhouMoKa = new MyZhouMoKaPage(d);
        pMyAiLvKa = new MyAiLvKaPage(d);
        pMyYouPiaoKa = new MyYouPiaoKaPage(d);
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

}
