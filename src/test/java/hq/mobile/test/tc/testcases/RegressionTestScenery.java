package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by hq11258 on 2015/6/2.
 * 测试用例 -- 景区
 */
public class RegressionTestScenery extends CommonTestcase{


    //==================== TestCases ====================

    /**
     * 会员下单
     * @param uid 用户名
     * @param pwd 密码
     * @param searchKeyword 搜索关键字
     * @param name 出游人姓名
     * @param phone 出游人电话
     * @param idCard 出游人身份证
     */
    @Parameters({
            "uid",
            "pwd",
            "searchKeyword",
            "name",
            "phone",
            "idCard"
    })
    @Test
    public void scenery0001(
            String uid,
            String pwd,
            String searchKeyword,
            String name,
            String phone,
            String idCard) {
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
            t.log("点击景区");
            pHome.imageViewScenery().click();
            //景区首页
            t.log("=== 景区首页 ===");
            Assert.assertEquals(pSceneryHome.funcSelfcheck("景区首页"), true);
            t.log("点击搜索框");
            pSceneryHome.textViewSearchText().click();
            //景区搜索页
            t.log("=== 景区搜索页 ===");
            Assert.assertEquals(pScenerySearch.funcSelfcheck("景区搜索页"), true);
            t.log(String.format("搜索关键字[%s]", searchKeyword));
            pScenerySearch.funcSearch(searchKeyword);
            //景区列表页
            t.log("=== 景区列表页 ===");
            Assert.assertEquals(pScenerySearchResult.funcSelfcheck("景区列表页"), true);
            t.log("点击第一个结果");
            pScenerySearchResult.textViewSceneryName().get(0).click();
            //景区详情页
            t.log("=== 景区详情页 ===");
            Assert.assertEquals(pSceneryDetail.funcSelfcheck("景区详情页"), true);
            t.log("点击预订按钮");
            pSceneryDetail.buttonOrder().get(0).click();
            //订单填写页
            t.log("=== 景区订单填写页 ===");
            Assert.assertEquals(pSceneryWriteOrder.funcSelfcheck("景区订单填写页"), true);
            pSceneryWriteOrder.funcSubmitOrder(name, phone, idCard);
            //订单提交完成页
            t.log("=== 订单提交结果页 ===");
            Assert.assertEquals(pSceneryOrderResult.funcSelfcheck("订单提交结果页"), true);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "scenery0001", "jpg");
            Assert.assertEquals(false, true);
        }
    }
}
