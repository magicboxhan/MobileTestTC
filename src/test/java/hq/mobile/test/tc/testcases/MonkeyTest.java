package hq.mobile.test.tc.testcases;

import hq.mobile.test.tc.common.Tools;
import hq.mobile.test.tc.monkey.MonkeyUtil;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by hq11258 on 2015/6/9.
 * Monkey测试用例
 */
public class MonkeyTest {

    public Tools t = new Tools();
    public MonkeyUtil m;

    @BeforeSuite
    public void setup_suite(
    ) {
        try {
            // 初始化suite
            t.log("=== 测试开始 ===");
        } catch (Exception e) {
            t.log("=== 测试开始出错 ===");
            e.printStackTrace();
            Assert.assertEquals(true, false);
        }
    }

    @AfterSuite
    public void teardown_suite() {
        try {
            t.log("=== 测试结束 ===");
        } catch (Exception e) {
            t.log("=== 测试结束出错 ===");
            e.printStackTrace();
            Assert.assertEquals(true, false);
        }
    }

    @Test
    public void test() {
        try {
            t.log("=== Monkey测试开始 ===");
            m = new MonkeyUtil("adb shell monkey -p com.tongcheng.android --pct-touch 50 --pct-motion 25 --pct-trackball 25 -v -v -v --ignore-crashes 50000");
//            m = new MonkeyUtil("adb shell monkey -p com.tongcheng.android --pct-touch 100 -v -v -v --ignore-crashes 100");
            m.runMonkey();
            m.printSeed();
            m.printCrash();
//            m.printLog();
        } catch (Exception e) {
            t.log("=== 测试出错 ===");
            e.printStackTrace();
            Assert.assertEquals(true, false);
        }
    }
}
