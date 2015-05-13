package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by hq11258 on 2015/5/8.
 * 测试用例 -- 公共
 */
public class RegressionTestCommon extends CommonTestcase {

    /**
     * 用例名称：我的 -- 未登录状态 -- 登录
     *
     * @param uid 用户名
     * @param pwd 密码
     */
    @Parameters({
            "uid",
            "pwd"
    })
    @Test
    public void common0001(String uid, String pwd) {
        try {
            t.log("===== 用例名称：我的 -- 未登录状态 -- 登录 =====");
            boolean result = true;
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_SHORT);
            enterHomepage();
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
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("验证登录");
            result &= pMy.funcVerifyLoginResult();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "common0001错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：点击会员信息入口
     */
    @Parameters({
    })
    @Test
    public void common0002() {
        try {
            boolean result = true;
            t.log("===== 用例名称：点击会员信息入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击用户名");
            pMy.textViewLoginName().click();
            t.log("=== 个人资料管理页 ===");
            result &= pUserInfo.funcSelfcheck("个人资料管理");
            t.log("点击后退，返回我的同程页");
            pUserInfo.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "common0002错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：签到入口跳转
     */
    @Parameters({
    })
    @Test
    public void common0003() {
        try {
            boolean result = true;
            t.log("===== 用例名称：签到入口跳转 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击签到");
            pMy.textViewQiandao().click();
            t.log("=== 签到页 ===");
            result &= pSignPage.funcSelfcheck("签到页");
            t.log("点击后退，返回我的同程页");
            pSignPage.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "common0003错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：我的消息入口
     */
    @Parameters({
    })
    @Test
    public void common0004() {
        try {
            boolean result = true;
            t.log("===== 用例名称：我的消息入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击我的消息");
            pMy.textViewMessage().click();
            t.log("=== 我的消息页 ===");
            result &= pMyMessage.funcSelfcheck("我的消息页");
            t.log("点击后退，返回我的同程页");
            pMyMessage.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "common0004错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：全部订单入口
     */
    @Parameters({
    })
    @Test
    public void common0005() {
        try {
            boolean result = true;
            t.log("===== 用例名称：全部订单入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击全部订单");
            pMy.textViewAllOrder().click();
            t.log("=== 全部订单页 ===");
            result &= pOrderList.funcSelfcheck("全部订单页");
            t.log("点击后退，返回我的同程页");
            pOrderList.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "common0005错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：待支付订单入口
     */
    @Parameters({
    })
    @Test
    public void common0006() {
        try {
            boolean result = true;
            t.log("===== 用例名称：待支付订单入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击待支付订单");
            pMy.textViewToPay().click();
            t.log("=== 待支付订单页 ===");
            result &= pOrderNeedPay.funcSelfcheck("待支付订单页");
            t.log("点击后退，返回我的同程页");
            pOrderNeedPay.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "common0006错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：待出行订单入口
     */
    @Parameters({
    })
    @Test
    public void common0007() {
        try {
            boolean result = true;
            t.log("===== 用例名称：待出行订单入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击待出行订单");
            pMy.textViewToTravel().click();
            t.log("=== 待出行订单页 ===");
            result &= pOrderNeedGo.funcSelfcheck("待出行订单页");
            t.log("点击后退，返回我的同程页");
            pOrderNeedGo.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "common0007错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：待点评订单入口
     */
    @Parameters({
    })
    @Test
    public void common0008() {
        try {
            boolean result = true;
            t.log("===== 用例名称：待点评订单入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击待点评订单");
            pMy.textViewToComment().click();
            t.log("=== 待点评订单页 ===");
            result &= pOrderNeedComment.funcSelfcheck("待点评订单页");
            t.log("点击后退，返回我的同程页");
            pOrderNeedComment.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            t.takeScreenshot(d, "common0008错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }
}
