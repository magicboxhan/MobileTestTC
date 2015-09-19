package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import hq.mobile.test.tc.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by hq11258 on 2015/5/8.
 * 测试用例 -- 公共 （业务相关）
 */
public class CommonTestcase extends BasicTestCase {

    //页面对象实体
    CommonPage pCommon;                                             //公共页
    LoadingPage pLoading;                                           //加载页
    Homepage pHome;                                                 //首页
    SearchPage pSearch;                                             //搜索页
    MyPage pMy;                                                     //我的同程页
    OrderListPage pOrderList;                                       //我的订单页
    LoginPage pLogin;                                               //登录页
    SceneryHomepage pSceneryHome;                                   //景区 - 首页
    ScenerySearchPage pScenerySearch;                               //景区 - 搜索页
    ScenerySearchResultPage pScenerySearchResult;                   //景点 - 景点列表页
    SceneryDetailPage pSceneryDetail;                               //景点 - 详情页
    SceneryWriteOrderPage pSceneryWriteOrder;                       //景点 - 订单填写页
    SceneryOrderResultPage pSceneryOrderResult;                     //景点 - 订单提交结果页
    MovieListPage pMovieList;                                       //电影票 - 影片列表页
    MovieCinemaListPage pMovieCinemaList;                           //电影票 - 影院列表页
    MovieSchedulePage pMovieSchedule;                               //电影票 - 场次列表页
    MovieSeatSelectPage pMovieSeatSelect;                           //电影票 - 选座页
    MovieWriteOrderPage pMovieWriteOrder;                           //电影票 - 订单填写页
    UserInfoPage pUserInfo;                                         //个人资料管理页
    MySignPage pMySignPage;                                             //签到页
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
    MyAssistantPage pMyAssistant;                                   //我的同程 - 行程助手
    MyChuJingDaRenPage pMyChuJingDaRen;                             //我的同程 - 出境达人
    MyYiYuanJingDianPage pMyYiYuanJingDian;                         //我的同程 - 一元景点
    MyChangYongXinXiPage pMyChangYongXinXi;                         //我的同程 - 常用信息
    MyChangYongLvKePage pMyChangYongLvKe;                           //常用信息 - 常用旅客
    MyChangYongYouJiDiZhiPage pMyChangYongYouJiDiZhi;               //常用信息 - 常用邮寄地址
    MyFavouritePage pMyFavourite;                                   //我的同程 - 我的收藏
    MyChuJingYouLunShouCangPage pMyChuJingYouLunShouCang;           //我的收藏 - 出境游轮收藏
    MyFaXianShouCang pMyFaXianShouCang;                             //我的收藏 - 发现收藏
    MyGongLueShouCangPage pMyGongLueShouCang;                       //我的收藏 - 攻略收藏
    MyJingDianMenPiaoShouCangPage pMyJingDianMenPiaoShouCang;       //我的收藏 - 景点门票收藏
    MyJiuDianShouCangPage pMyJiuDianShouCang;                       //我的收藏 - 酒店收藏
    MyZhouBianYouShouCangPage pMyZhouBianYouShouCang;               //我的收藏 - 周边游收藏
    TravelHomepage pTravelHome;                                     //周边游 - 首页
    TravelSearchPage pTravelSearch;                                 //周边游 - 搜索页
    TravelSearchResultPage pTravelSearchResult;                     //周边游 - 搜索结果页
    TravelDetailPage pTravelDetail;                                 //周边游 - 详情页
    TravelTicketListPage pTravelTicketList;                         //周边游 - 套餐列表
    TravelWriteOrderPage pTravelWriteOrder;                         //周边游 - 订单填写页
    TravelOrderResultPage pTravelOrderResult;                       //周边游 - 订单提交结果页
    CalendarPage pCalendar;                                         //日历选择页

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
        pCommon = new CommonPage(d);
        pLoading = new LoadingPage(d);
        pHome = new Homepage(d);
        pSearch = new SearchPage(d);
        pSceneryHome = new SceneryHomepage(d);
        pScenerySearch = new ScenerySearchPage(d);
        pScenerySearchResult = new ScenerySearchResultPage(d);
        pSceneryDetail = new SceneryDetailPage(d);
        pSceneryOrderResult = new SceneryOrderResultPage(d);
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
        pMySignPage = new MySignPage(d);
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
        pMyAssistant = new MyAssistantPage(d);
        pMyChuJingDaRen = new MyChuJingDaRenPage(d);
        pMyYiYuanJingDian = new MyYiYuanJingDianPage(d);
        pMyChangYongXinXi = new MyChangYongXinXiPage(d);
        pMyChangYongLvKe = new MyChangYongLvKePage(d);
        pMyChangYongYouJiDiZhi = new MyChangYongYouJiDiZhiPage(d);
        pMyFavourite = new MyFavouritePage(d);
        pMyChuJingYouLunShouCang = new MyChuJingYouLunShouCangPage(d);
        pMyFaXianShouCang = new MyFaXianShouCang(d);
        pMyGongLueShouCang = new MyGongLueShouCangPage(d);
        pMyJingDianMenPiaoShouCang = new MyJingDianMenPiaoShouCangPage(d);
        pMyJiuDianShouCang = new MyJiuDianShouCangPage(d);
        pMyZhouBianYouShouCang = new MyZhouBianYouShouCangPage(d);
        pTravelHome = new TravelHomepage(d);
        pTravelSearch = new TravelSearchPage(d);
        pTravelSearchResult = new TravelSearchResultPage(d);
        pTravelDetail = new TravelDetailPage(d);
        pTravelTicketList = new TravelTicketListPage(d);
        pTravelWriteOrder = new TravelWriteOrderPage(d);
        pTravelOrderResult = new TravelOrderResultPage(d);
        pCalendar = new CalendarPage(d);
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
//        pHome.funcCheckLocation(cityName);
    }

    /**
     * 从首页登录
     *
     * @param uid 用户名
     * @param pwd 密码
     * @throws InterruptedException
     */
    public void login(String uid, String pwd) throws InterruptedException {
        t.log("=== 首页 ===");
        t.log("点击“我的”");
        pHome.imageViewMy().click();
        t.log("=== 我的同程页 ===");
        t.log("点击登录");
        pMy.textViewLogin().click();
        t.log("=== 登录页 ===");
        t.log(String.format("输入用户名：[%s]，密码：[%s]", uid, pwd));
        t.log("点击登录按钮");
        pLogin.funcLogin(uid, pwd);
    }

}
