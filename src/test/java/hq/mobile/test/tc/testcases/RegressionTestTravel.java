package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by hq11258 on 2015/5/22.
 * 测试用例 -- 周边游
 */
public class RegressionTestTravel extends CommonTestcase{


    //==================== Common Functions ====================

    /**
     * 从首页开始搜索周边游产品，并进入产品详情页
     * @param searchKeyword
     * @throws InterruptedException
     */
    public void searchTravelAndViewDetail(String searchKeyword) throws InterruptedException {
        pHome.imageViewTravel().click();
        //周边游首页
        t.log("=== 周边游首页 ===");
        if (pTravelHome.funcSwitchToWebView()) {
            //WebView切换成功
            pTravelHome.funcWaitForKeyElement(BasicTestCase.WAIT_KEY_ELEMENT);
            Assert.assertEquals(pTravelHome.funcSelfcheck("周边游首页"), true);
            pTravelHome.funcSwitchToWebView();
        } else {
            //WebView切换失败
            t.log(">>>>>>>>>> 自检失败");
            t.takeScreenshot(d, "[周边游首页]自检失败截图", "jpg");
            Assert.assertEquals(false, true);
        }
        t.log("点击搜索框");
        pTravelHome.aSearchText().click();
        pTravelHome.funcSwitchToNativeView();
        //周边游搜索页
        t.log("=== 周边游搜索页 ===");
        Assert.assertEquals(pTravelSearch.funcSelfcheck("周边游搜索页"), true);
        t.log(String.format("搜索关键字[%s]", searchKeyword));
        pTravelSearch.funcSearch(searchKeyword);
        //搜索结果页
        t.log("=== 周边游搜索结果页 ===");
        Assert.assertEquals(pTravelSearchResult.funcSelfcheck("周边游搜索结果页"), true);
        t.log("点击第一个产品");
        pTravelSearchResult.textViewTravelName().get(0).click();
    }



    //==================== TestCases ====================

    /**
     * 会员下单
     * @param uid 用户名
     * @param pwd 密码
     * @param searchKeyword 搜索关键字
     * @param name 出游人姓名
     * @param phone 出游人电话
     * @param idCard 出游人身份证
     * @param isMultiHotel 是否多酒店（0：否，1：是）
     */
    @Parameters({
            "uid",
            "pwd",
            "searchKeyword",
            "name",
            "phone",
            "idCard",
            "isMultiHotel"
    })
    @Test
    public void travel0001(
            String uid,
            String pwd,
            String searchKeyword,
            String name,
            String phone,
            String idCard,
            int isMultiHotel) {
        try {
            t.log("===== 用例名称：会员下单 =====");
            boolean result = true;
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
            enterHomepage();
            login(uid, pwd);
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("验证登录");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程页"), true);
            pMy.imageViewHome().click();
            //首页
            t.log("=== 首页 ===");
            Assert.assertEquals(pHome.funcSelfcheck("首页"), true);
            //搜索周边游线路并进入产品详情页
            searchTravelAndViewDetail(searchKeyword);
            //产品详情页
            t.log("=== 周边游详情页 ===");
            Assert.assertEquals(pTravelDetail.funcSelfcheck("周边游详情页"), true);
            t.log("点击查看套餐");
            pTravelDetail.textViewBook().click();
            //套餐列表页
            t.log("=== 套餐列表页 ===");
            Assert.assertEquals(pTravelTicketList.funcSelfcheck("套餐列表页"), true);
            t.log("点击套餐");
            if(pTravelTicketList.buttonBook().size() > 1) {
                //有第二个点第二个，某些产品日历只能选本月，不好搞
                pTravelTicketList.buttonBook().get(1).click();
            }else{
                pTravelTicketList.buttonBook().get(0).click();
            }
            t.log("=== 日历选择页 ===");
            Assert.assertEquals(pCalendar.funcSelfcheck("日历选择页"), true);
            t.log("选择日历");
            pCalendar.textViewCalendarCell(1, 0, 0).click();
            //订单填写页
            t.log("=== 订单填写页 ===");
            Assert.assertEquals(pTravelWriteOrder.funcSelfcheck("订单填写页"), true);
            t.log("填写订单信息");
            pTravelWriteOrder.funcWriteOrder(name, phone, idCard, isMultiHotel);
            //订单提交结果页
            t.log("=== 订单提交结果页 ===");
            Assert.assertEquals(pTravelOrderResult.funcSelfcheck("订单提交结果页"), true);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "travel0001", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 非会员下单
     * @param searchKeyword 搜索关键字
     * @param name 出游人姓名
     * @param phone 出游人电话
     * @param idCard 出游人身份证
     * @param isMultiHotel 是否多酒店（0：否，1：是）
     */
    @Parameters({
            "searchKeyword",
            "name",
            "phone",
            "idCard",
            "isMultiHotel"
    })
    @Test
    public void travel0002(
            String searchKeyword,
            String name,
            String phone,
            String idCard,
            int isMultiHotel) {
        try {
            t.log("===== 用例名称：非会员下单 =====");
            boolean result = true;
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
            enterHomepage();
            //首页
            t.log("=== 首页 ===");
            Assert.assertEquals(pHome.funcSelfcheck("首页"), true);
            //搜索周边游线路并进入产品详情页
            searchTravelAndViewDetail(searchKeyword);
            //产品详情页
            t.log("=== 周边游详情页 ===");
            Assert.assertEquals(pTravelDetail.funcSelfcheck("周边游详情页"), true);
            t.log("点击查看套餐");
            pTravelDetail.textViewBook().click();
            //套餐列表页
            t.log("=== 套餐列表页 ===");
            Assert.assertEquals(pTravelTicketList.funcSelfcheck("套餐列表页"), true);
            t.log("点击第一个套餐");
            pTravelTicketList.buttonBook().get(0).click();
            //非会员登录
            t.log("=== 登录页 ===");
            Assert.assertEquals(pLogin.funcSelfcheck("登录页"), true);
            pLogin.buttonNoMemberCommit().click();
            //日历选择页
            t.log("=== 日历选择页 ===");
            Assert.assertEquals(pCalendar.funcSelfcheck("日历选择页"), true);
            t.log("选择日历");
            pCalendar.textViewCalendarCell(1, 0, 0).click();
            //订单填写页
            t.log("=== 订单填写页 ===");
            Assert.assertEquals(pTravelWriteOrder.funcSelfcheck("订单填写页"), true);
            t.log("填写订单信息");
            pTravelWriteOrder.funcWriteOrder(name, phone, idCard, isMultiHotel);
            //订单提交结果页
            t.log("=== 订单提交结果页 ===");
            Assert.assertEquals(pTravelOrderResult.funcSelfcheck("订单提交结果页"), true);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "travel0002", "jpg");
            Assert.assertEquals(false, true);
        }
    }

}
