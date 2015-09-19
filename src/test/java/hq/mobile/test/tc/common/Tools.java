package hq.mobile.test.tc.common;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by hanqing on 2015/3/27.
 * 工具类
 */
public class Tools {

    protected Logger l = LogManager.getLogger(this.getClass().getName());
    String code = "hqhqhqhqhq";

    /**
     * 截图
     *
     * @param d        AppiumDriver
     * @param fileName 保存图片的文件名
     * @param extName  保存图片的扩展名
     */
    public void takeScreenshot(AppiumDriver d, String fileName, String extName) {
        try {
            String filePath = System.getProperty("user.dir");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String timeStr = df.format(new Date());
            File screenShotFile = d.getScreenshotAs(OutputType.FILE);
            String fileFullPath = String.format("%s//%s_%s.%s", filePath, fileName, timeStr, extName);
            FileUtils.copyFile(screenShotFile, new File(fileFullPath));
            String fileFullName = String.format("%s_%s.%s", fileName, timeStr, extName);
//            log(String.format("截图文件名：%s", fileFullName));
            log(String.format("%s<a href=\"../../%s\" target=\"_blank\">截图链接：%s</a>", code, fileFullName, fileFullName));
        } catch (Exception e) {
            log(">>>>>>>>>> 截图时出错");
            e.printStackTrace();
        }
    }

    /**
     * 同时使用log4j2和reportng记录日志
     *
     * @param info 日志内容
     */
    public void log(String info) {
        if (info != null) {
            l.info(info.replace(code, ""));
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Reporter.log(String.format("%s - %s", sdf.format(Calendar.getInstance().getTime()), info));
        }
    }

    /**
     * 执行cmd命令
     *
     * @param cmd 命令
     * @return
     */
    public List<String> runCommand(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            return getShellResult(p);
        } catch (Exception e) {
            log(">>>>>>>>>> 执行命令时出错");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 收集shell脚本运行的结果集
     *
     * @param process
     * @return
     */
    public List<String> getShellResult(Process process) {
        List<String> output = new ArrayList<String>();
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                if (!"".equals(line)) {
                    output.add(line);
                }
            }
            if (input != null) {
                input.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        output.forEach(this::log);
        return output;
    }

    /**
     * 获取内存信息
     *
     * @return 0:Native Heap (PSS); 1:Dalvik Heap  (PSS); 2:TOTAL PSS; 3:PID
     */
    public List<String> getMemeryInfo() {
        try {
            List<String> memInfo = new ArrayList<>();
            List<String> results = runCommand("adb shell dumpsys meminfo com.tongcheng.android");
            String nativePss = "";
            String dalvikPss = "";
            String totalPss = "";
            String pid = "";
            for (String line : results) {
                line = line.trim();
                if (line.startsWith("Native Heap")) {
                    //Native Heap (Pss Total)
                    nativePss = line.split("\\s+")[2];
//                    log(String.format("Native Heap (PSS): %s KB", nativePss));
                } else if (line.startsWith("Dalvik Heap")) {
                    //Dalvik Heap (Pss Total)
                    dalvikPss = line.split("\\s+")[2];
//                    log(String.format("Dalvik Heap (PSS): %s KB", dalvikPss));
                } else if (line.startsWith("TOTAL")) {
                    //TOTAL Pss
                    totalPss = line.split("\\s+")[1];
//                    log(String.format("TOTAL PSS: %s KB", totalPss));
                } else if (line.startsWith("** MEMINFO")) {
                    //PID
                    pid = line.split("\\s+")[4];
//                    log(String.format("PID: %s", pid));
                }
            }
            memInfo.add(0, nativePss);
            memInfo.add(1, dalvikPss);
            memInfo.add(2, totalPss);
            memInfo.add(3, pid);
            return memInfo;
        } catch (Exception e) {
            log(">>>>>>>>>> 获取内存数据出错");
            e.printStackTrace();
            return null;
        }
    }

}
