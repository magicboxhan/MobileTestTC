package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import hq.mobile.test.tc.pageobjects.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by hq11258 on 2015/5/8.
 * 测试用例 -- 公共
 */
public class CommonTestcase extends BasicTestCase {

    //页面对象实体
    LoadingPage pLoading;
    Homepage pHome;
    SearchPage pSearch;
    ScenerySearchResultPage pSearchResult;
    SceneryDetailPage pSceneryDetail;
    MyPage pMy;
    LoginPage pLogin;
    MovieListPage pMovieList;
    MovieCinemaListPage pMovieCinemaList;
    MovieSchedulePage pMovieSchedule;
    MovieSeatSelectPage pMovieSeatSelect;
    MovieWriteOrderPage pMovieWriteOrder;
    SceneryWriteOrderPage pSceneryWriteOrder;
    OrderListPage pOrderList;

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
    }

    /**
     * 进入首页
     *
     * @throws InterruptedException
     */
    public void enterHomepage() throws InterruptedException {
        t.log("=== 开始页 ===");
        t.log("滑动并进入首页");
        pLoading = new LoadingPage(d);
        pLoading.funcEnterHomepage();
        //如果定位失败，则手工定位
        pHome = new Homepage(d);
        pHome.funcCheckLocation(cityName);
    }

}
