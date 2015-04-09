package hq.mobile.test.tc.common;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hanqing on 2015/3/27.
 * 工具类
 */
public class Tools {

    protected Logger l = LogManager.getLogger(this.getClass().getName());
    
    /**
     * 截图
     * @param d         AppiumDriver
     * @param fileName  保存图片的文件名
     * @param extName   保存图片的扩展名
     */
    public void takeScreenshot(AppiumDriver d, String fileName, String extName){
        try{
            String filePath = System.getProperty("user.dir");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String timeStr = df.format(new Date());
            File screenShotFile = d.getScreenshotAs(OutputType.FILE);
            String fileFullPath = String.format("%s//%s_%s.%s", filePath, fileName, timeStr, extName);
            FileUtils.copyFile(screenShotFile, new File(fileFullPath));
            log(String.format("Screenshot file name: %s_%s.%s", fileName, timeStr, extName));
        }catch (Exception e) {
            log("Error when taking screenshot");
            e.printStackTrace();
        }
    }

    /**
     * 同时使用log4j2和reportng记录日志
     * @param info  日志内容
     */
    public void log(String info){
        l.info(info);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Reporter.log(String.format("%s - %s", sdf.format(Calendar.getInstance().getTime()), info));
    }
    
}
