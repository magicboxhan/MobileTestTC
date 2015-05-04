package hq.mobile.test.tc.common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by hanqing on 2015/3/27.
 * 框架基类，用于定义测试用例
 */
public class BasicTestCase {

    protected Tools t = new Tools();
    protected AppiumDriver d;
    protected final static int WAIT_TIME_VERY_LONG = 30;
    protected final static int WAIT_TIME_LONG = 15;
    protected final static int WAIT_TIME_MIDDLE = 10;
    protected final static int WAIT_TIME_SHORT = 5;
    protected final static int WAIT_WEB_VIEW = 20; //Webview页面加载等待时间

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

    /**
     * 初始化
     *
     * @param appDir             APK路径
     * @param appName            APK名称
     * @param deviceName         设备名称
     * @param platformName       平台名称
     * @param platformVersion    系统版本
     * @param appPackage         被测试包名
     * @param appActivity        被测试activity名
     * @param appiumURL          appium服务地址
     * @param implicitlyWaitTime 隐性等待时间
     */
    @Parameters({
            "appDir",
            "appName",
            "deviceName",
            "platformName",
            "platformVersion",
            "appPackage",
            "appActivity",
            "appiumURL",
            "implicitlyWaitTime"
    })
    @BeforeTest
    public void setup_test(
            String appDir,
            String appName,
            String deviceName,
            String platformName,
            String platformVersion,
            String appPackage,
            String appActivity,
            String appiumURL,
            int implicitlyWaitTime
    ) {
        try {
            File dir = new File(appDir);
            File app = new File(dir, appName);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("unicodeKeyboard", "True");    //可以输入中文
            capabilities.setCapability("resetKeyboard", "True");        //隐藏键盘
//            d = new AndroidDriver(new URL(appiumURL), capabilities);
            d = new AppiumDriver(new URL(appiumURL), capabilities) {
                @Override
                public MobileElement scrollTo(String s) {
                    return null;
                }

                @Override
                public MobileElement scrollToExact(String s) {
                    return null;
                }
            };
            d.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.assertEquals(true, false);
        }
    }

    @AfterTest
    public void teardown_test() {
        try {
            d.quit();
        } catch (Exception e) {
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
    
}
