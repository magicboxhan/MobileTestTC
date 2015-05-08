package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.BasicTestCase;
import hq.mobile.test.tc.pageobjects.Homepage;
import hq.mobile.test.tc.pageobjects.LoginPage;
import hq.mobile.test.tc.pageobjects.MyPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by hq11258 on 2015/5/8.
 * 测试用例 -- 公共
 */
public class RegressionTestCommon extends CommonTestcase {

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
    public void common0001(String uid, String pwd) {
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
            t.takeScreenshot(d, "errorCommon0001", "jpg");
            Assert.assertEquals(false, true);
        }
    }
}
