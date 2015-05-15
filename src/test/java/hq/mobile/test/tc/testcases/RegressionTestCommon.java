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
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
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
            pCommon.funcSwitchToNativeView();
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
            pCommon.funcSwitchToNativeView();
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
            result &= pMySignPage.funcSelfcheck("签到页");
            t.log("点击后退，返回我的同程页");
            pMySignPage.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
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
            pCommon.funcSwitchToNativeView();
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
            pCommon.funcSwitchToNativeView();
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
            pCommon.funcSwitchToNativeView();
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
            pCommon.funcSwitchToNativeView();
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
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0008错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：我的财富入口
     */
    @Parameters({
            "uid",
            "pwd"
    })
    @Test
    public void common0009(String uid, String pwd) {
        try {
            boolean result = true;
            t.log("===== 用例名称：我的财富入口 =====");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
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
            t.log("点击我的财富");
            pMy.textViewMyWealth().click();
            t.log("=== 我的财富页 ===");
            Assert.assertEquals(pMyWealth.funcSelfcheck("我的财富"), true);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0009错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：奖金账户入口
     */
    @Parameters({
    })
    @Test
    public void common0010() {
        try {
            boolean result = true;
            t.log("===== 用例名称：奖金账户入口 =====");
            t.log("=== 我的财富页 ===");
            Assert.assertEquals(pMyWealth.funcSelfcheck("我的财富"), true);
            t.log("点击奖金账户");
            pMyWealth.textViewJiangJin().click();
            t.log("=== 奖金账户页 ===");
            result &= pMyJiangJinZhangHu.funcSelfcheck("奖金账户");
            t.log("点击后退，返回我的财富页");
            pMyJiangJinZhangHu.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0010错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：立返账户入口
     */
    @Parameters({
    })
    @Test
    public void common0011() {
        try {
            boolean result = true;
            t.log("===== 用例名称：立返账户入口 =====");
            t.log("=== 我的财富页 ===");
            Assert.assertEquals(pMyWealth.funcSelfcheck("我的财富"), true);
            t.log("点击立返账户");
            pMyWealth.textViewLiFan().click();
            t.log("=== 立返账户页 ===");
            result &= pMyLiFanZhangHu.funcSelfcheck("立返账户");
            t.log("点击后退，返回我的财富页");
            pMyLiFanZhangHu.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0011错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：抵现红包入口
     */
    @Parameters({
    })
    @Test
    public void common0012() {
        try {
            boolean result = true;
            t.log("===== 用例名称：抵现红包入口 =====");
            t.log("=== 我的财富页 ===");
            Assert.assertEquals(pMyWealth.funcSelfcheck("我的财富"), true);
            t.log("点击抵现红包");
            pMyWealth.textViewDiXian().click();
            t.log("=== 抵现红包页 ===");
            result &= pMyDiXianHongBao.funcSelfcheck("抵现红包");
            t.log("点击后退，返回我的财富页");
            pMyDiXianHongBao.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0012错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：返现红包入口
     */
    @Parameters({
    })
    @Test
    public void common0013() {
        try {
            boolean result = true;
            t.log("===== 用例名称：返现红包入口 =====");
            t.log("=== 我的财富页 ===");
            Assert.assertEquals(pMyWealth.funcSelfcheck("我的财富"), true);
            t.log("点击返现红包");
            pMyWealth.textViewFanXian().click();
            t.log("=== 返现红包页 ===");
            if (pMyFanXianHongBao.funcSwitchToWebView()) {
                //WebView切换成功
                pMyFanXianHongBao.funcWaitForKeyElement(BasicTestCase.WAIT_KEY_ELEMENT);
                result &= pMyFanXianHongBao.funcSelfcheck("返现红包");
                pMyWealth.funcSwitchToNativeView();
            } else {
                //WebView切换失败
                t.log(">>>>>>>>>> 自检失败");
                t.takeScreenshot(d, "自检失败截图", "jpg");
                result &= false;
            }
            t.log("点击后退，返回我的财富页");
            pMyFanXianHongBao.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0013错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：我的卡券入口
     */
    @Parameters({
            "uid",
            "pwd"
    })
    @Test
    public void common0014(String uid, String pwd) {
        try {
            boolean result = true;
            t.log("===== 用例名称：我的卡券入口 =====");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
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
            t.log("点击我的卡券");
            pMy.textViewMyCard().click();
            t.log("=== 我的卡券页 ===");
            Assert.assertEquals(pMyCard.funcSelfcheck("我的卡券"), true);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0014错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：电子票入口
     */
    @Parameters({
    })
    @Test
    public void common0015() {
        try {
            boolean result = true;
            t.log("===== 用例名称：电子票入口 =====");
            t.log("=== 我的卡券页 ===");
            Assert.assertEquals(pMyCard.funcSelfcheck("我的卡券"), true);
            t.log("点击电子票");
            pMyCard.textViewDianZiPiao().click();
            t.log("=== 电子票页 ===");
            result &= pMyDianZiPiao.funcSelfcheck("电子票");
            t.log("点击后退，返回我的卡券页");
            pMyDianZiPiao.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0015错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：周末卡入口
     */
    @Parameters({
    })
    @Test
    public void common0016() {
        try {
            boolean result = true;
            t.log("===== 用例名称：周末卡入口 =====");
            t.log("=== 我的卡券页 ===");
            Assert.assertEquals(pMyCard.funcSelfcheck("我的卡券"), true);
            t.log("点击周末卡");
            pMyCard.textViewZhouMoKa().click();
            t.log("=== 周末卡页 ===");
            result &= pMyZhouMoKa.funcSelfcheck("周末卡");
            t.log("点击后退，返回我的卡券页");
            pMyZhouMoKa.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0016错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：爱旅卡入口
     */
    @Parameters({
    })
    @Test
    public void common0017() {
        try {
            boolean result = true;
            t.log("===== 用例名称：爱旅卡入口 =====");
            t.log("=== 我的卡券页 ===");
            Assert.assertEquals(pMyCard.funcSelfcheck("我的卡券"), true);
            t.log("点击爱旅卡");
            pMyCard.textViewAiLvKa().click();
            t.log("=== 爱旅卡页 ===");
            if (pMyAiLvKa.funcSwitchToWebView()) {
                //WebView切换成功
                pMyAiLvKa.funcWaitForKeyElement(BasicTestCase.WAIT_KEY_ELEMENT);
                result &= pMyAiLvKa.funcSelfcheck("爱旅卡");
                pMyAiLvKa.funcSwitchToNativeView();
            } else {
                //WebView切换失败
                t.log(">>>>>>>>>> 自检失败");
                t.takeScreenshot(d, "自检失败截图", "jpg");
                result &= false;
            }
            t.log("点击后退，返回我的卡券页");
            pMyAiLvKa.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0017错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：有票卡入口
     */
    @Parameters({
    })
    @Test
    public void common0018() {
        try {
            boolean result = true;
            t.log("===== 用例名称：有票卡入口 =====");
            t.log("=== 我的卡券页 ===");
            Assert.assertEquals(pMyCard.funcSelfcheck("我的卡券"), true);
            t.log("点击有票卡");
            pMyCard.textViewYouPiaoKa().click();
            t.log("=== 有票卡页 ===");
            if (pMyYouPiaoKa.funcSwitchToWebView()) {
                //WebView切换成功
                pMyYouPiaoKa.funcWaitForKeyElement(BasicTestCase.WAIT_KEY_ELEMENT);
                result &= pMyYouPiaoKa.funcSelfcheck("有票卡");
                pMyYouPiaoKa.funcSwitchToNativeView();
            } else {
                //WebView切换失败
                t.log(">>>>>>>>>> 自检失败");
                t.takeScreenshot(d, "自检失败截图", "jpg");
                result &= false;
            }
            t.log("点击后退，返回我的卡券页");
            pMyYouPiaoKa.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0018错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：行程助手入口
     */
    @Parameters({
    })
    @Test
    public void common0019() {
        try {
            boolean result = true;
            t.log("===== 用例名称：行程助手入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击行程助手");
            pMy.textViewAssistant().click();
            t.log("=== 行程助手页 ===");
            result &= pMyAssistant.funcSelfcheck("行程助手");
            t.log("点击后退，返回我的同程页");
            pMyAssistant.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0019错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：出境达人入口
     */
    @Parameters({
    })
    @Test
    public void common0020() {
        try {
            boolean result = true;
            t.log("===== 用例名称：出境达人入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击出境达人");
            pMy.textViewChuJingCard().click();
            t.log("=== 出境达人页 ===");
            if (pMyChuJingDaRen.funcSwitchToWebView()) {
                //WebView切换成功
                pMyChuJingDaRen.funcWaitForKeyElement(BasicTestCase.WAIT_KEY_ELEMENT);
                result &= pMyChuJingDaRen.funcSelfcheck("出境达人");
                pMyChuJingDaRen.funcSwitchToNativeView();
            } else {
                //WebView切换失败
                t.log(">>>>>>>>>> 自检失败");
                t.takeScreenshot(d, "自检失败截图", "jpg");
                result &= false;
            }
            t.log("点击后退，返回我的同程页");
            pMyChuJingDaRen.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0020错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：一元景点日历入口
     */
    @Parameters({
    })
    @Test
    public void common0021() {
        try {
            boolean result = true;
            t.log("===== 用例名称：一元景点日历入口 =====");
            t.log("=== 我的同程页 ===");
            Assert.assertEquals(pMy.funcSelfcheck("我的同程"), true);
            t.log("点击一元景点日历");
            pMy.textViewYiYuanJingDianRiLi().click();
            t.log("=== 一元景点日历页 ===");
            result &= pMyYiYuanJingDian.funcSelfcheck("一元景点日历");
            t.log("点击后退，返回我的同程页");
            pMyYiYuanJingDian.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0021错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：常用信息入口
     */
    @Parameters({
            "uid",
            "pwd"
    })
    @Test
    public void common0022(String uid, String pwd) {
        try {
            boolean result = true;
            t.log("===== 用例名称：常用信息入口 =====");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
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
            t.log("向上滑动屏幕");
            pMy.funcSwipeUp();
            t.log("点击常用信息");
            pMy.textViewChangYongXinXi().click();
            t.log("=== 常用信息页 ===");
            Assert.assertEquals(pMyChangYongXinXi.funcSelfcheck("常用信息"), true);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0022错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：常用旅客入口
     */
    @Parameters({
    })
    @Test
    public void common0023() {
        try {
            boolean result = true;
            t.log("===== 用例名称：常用旅客入口 =====");
            t.log("=== 常用信息页 ===");
            Assert.assertEquals(pMyChangYongXinXi.funcSelfcheck("常用信息"), true);
            t.log("点击常用旅客");
            pMyChangYongXinXi.textViewChangYongLvKe().click();
            t.log("=== 常用旅客页 ===");
            result &= pMyChangYongLvKe.funcSelfcheck("常用旅客");
            t.log("点击后退，返回常用信息页");
            pMyChangYongLvKe.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0023错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：常用邮寄地址入口
     */
    @Parameters({
    })
    @Test
    public void common0024() {
        try {
            boolean result = true;
            t.log("===== 用例名称：常用邮寄地址入口 =====");
            t.log("=== 常用信息页 ===");
            Assert.assertEquals(pMyChangYongXinXi.funcSelfcheck("常用信息"), true);
            t.log("点击常用邮寄地址");
            pMyChangYongXinXi.textViewChangYongYouJiDiZhi().click();
            t.log("=== 常用邮寄地址页 ===");
            result &= pMyChangYongYouJiDiZhi.funcSelfcheck("常用邮寄地址");
            t.log("点击后退，返回常用信息页");
            pMyChangYongYouJiDiZhi.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0024错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：我的收藏入口
     */
    @Parameters({
            "uid",
            "pwd"
    })
    @Test
    public void common0025(String uid, String pwd) {
        try {
            boolean result = true;
            t.log("===== 用例名称：我的收藏入口 =====");
            Thread.sleep(1000 * BasicTestCase.WAIT_TIME_MIDDLE);
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
            t.log("向上滑动屏幕");
            pMy.funcSwipeUp();
            t.log("点击我的收藏");
            pMy.textViewMyFavourite().click();
            t.log("=== 我的收藏页 ===");
            Assert.assertEquals(pMyFavourite.funcSelfcheck("我的收藏"), true);
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0025错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：酒店收藏入口
     */
    @Parameters({
    })
    @Test
    public void common0026() {
        try {
            boolean result = true;
            t.log("===== 用例名称：酒店收藏入口 =====");
            t.log("=== 我的收藏页 ===");
            Assert.assertEquals(pMyFavourite.funcSelfcheck("我的收藏"), true);
            t.log("点击酒店收藏");
            pMyFavourite.textViewJiuDianShouCang().click();
            t.log("=== 酒店收藏页 ===");
            result &= pMyJiuDianShouCang.funcSelfcheck("酒店收藏");
            t.log("点击后退，返回我的收藏页");
            pMyJiuDianShouCang.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0026错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：景点门票收藏入口
     */
    @Parameters({
    })
    @Test
    public void common0027() {
        try {
            boolean result = true;
            t.log("===== 用例名称：景点门票收藏入口 =====");
            t.log("=== 我的收藏页 ===");
            Assert.assertEquals(pMyFavourite.funcSelfcheck("我的收藏"), true);
            t.log("点击景点门票收藏");
            pMyFavourite.textViewJingDianMenPiaoShouCang().click();
            t.log("=== 景点门票收藏页 ===");
            result &= pMyJingDianMenPiaoShouCang.funcSelfcheck("景点门票收藏");
            t.log("点击后退，返回我的收藏页");
            pMyJingDianMenPiaoShouCang.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0027错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：周边游收藏入口
     */
    @Parameters({
    })
    @Test
    public void common0028() {
        try {
            boolean result = true;
            t.log("===== 用例名称：周边游收藏入口 =====");
            t.log("=== 我的收藏页 ===");
            Assert.assertEquals(pMyFavourite.funcSelfcheck("我的收藏"), true);
            t.log("点击周边游收藏");
            pMyFavourite.textViewZhouBianYouShouCang().click();
            t.log("=== 周边游收藏页 ===");
            result &= pMyZhouBianYouShouCang.funcSelfcheck("周边游收藏");
            t.log("点击后退，返回我的收藏页");
            pMyZhouBianYouShouCang.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0028错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：出境邮轮收藏入口
     */
    @Parameters({
    })
    @Test
    public void common0029() {
        try {
            boolean result = true;
            t.log("===== 用例名称：出境邮轮收藏入口 =====");
            t.log("=== 我的收藏页 ===");
            Assert.assertEquals(pMyFavourite.funcSelfcheck("我的收藏"), true);
            t.log("点击出境邮轮收藏");
            pMyFavourite.textViewChuJingYouLunShouCang().click();
            t.log("=== 酒店收藏页 ===");
            result &= pMyChuJingYouLunShouCang.funcSelfcheck("出境邮轮收藏");
            t.log("点击后退，返回我的收藏页");
            pMyChuJingYouLunShouCang.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0029错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：攻略收藏入口
     */
    @Parameters({
    })
    @Test
    public void common0030() {
        try {
            boolean result = true;
            t.log("===== 用例名称：攻略收藏入口 =====");
            t.log("=== 我的收藏页 ===");
            Assert.assertEquals(pMyFavourite.funcSelfcheck("我的收藏"), true);
            t.log("点击攻略收藏");
            pMyFavourite.textViewGongLueShouCang().click();
            t.log("=== 攻略收藏页 ===");
            result &= pMyGongLueShouCang.funcSelfcheck("攻略收藏");
            t.log("点击后退，返回我的收藏页");
            pMyGongLueShouCang.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0030错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }

    /**
     * 用例名称：发现收藏入口
     */
    @Parameters({
    })
    @Test
    public void common0031() {
        try {
            boolean result = true;
            t.log("===== 用例名称：发现收藏入口 =====");
            t.log("=== 我的收藏页 ===");
            Assert.assertEquals(pMyFavourite.funcSelfcheck("我的收藏"), true);
            t.log("点击发现收藏");
            pMyFavourite.textViewFaXianShouCang().click();
            t.log("=== 发现收藏页 ===");
            result &= pMyFaXianShouCang.funcSelfcheck("发现收藏");
            t.log("点击后退，返回我的收藏页");
            pMyFaXianShouCang.textViewBack().click();
            Assert.assertEquals(result, true);
        } catch (Exception e) {
            t.log(">>>>>>>>>> 测试出错");
            e.printStackTrace();
            t.log(e.getMessage());
            pCommon.funcSwitchToNativeView();
            t.takeScreenshot(d, "common0031错误截图", "jpg");
            Assert.assertEquals(false, true);
        }
    }
}
