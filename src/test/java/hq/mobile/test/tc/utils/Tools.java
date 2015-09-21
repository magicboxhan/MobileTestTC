package hq.mobile.test.tc.utils;

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
import java.text.DecimalFormat;
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
//        output.forEach(this::log);
        return output;
    }

    /**
     * 获取内存信息
     *
     * @param pkgName 包名
     * @return 0:Native Heap (PSS); 1:Dalvik Heap  (PSS); 2:TOTAL PSS; 3:PID
     */
    public MemeryInfo getMemeryInfo(String pkgName) {
        try {
            List<String> results = runCommand(String.format("adb shell dumpsys meminfo %s", pkgName));
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
            MemeryInfo memInfo = new MemeryInfo(pid, nativePss, dalvikPss, totalPss);
            return memInfo;
        } catch (Exception e) {
            log(">>>>>>>>>> 获取内存数据出错");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取某时间点上的CPU时间信息
     *
     * @param pid 进程ID
     * @return CPU信息实体
     */
    public CPUInfo getCPUInfo(String pid) {
        try {
            //总体CPU时间
            long user = 0;
            long nice = 0;
            long system = 0;
            long idle = 0;
            long iowait = 0;
            long irq = 0;
            long softirq = 0;
            //单进程CPU时间
            long utime = 0;
            long stime = 0;
            long cutime = 0;
            long cstime = 0;
            //获取总体CPU时间
            List<String> results = runCommand("adb shell cat /proc/stat");
            for (String line : results) {
                line = line.trim();
                if (line.startsWith("cpu")) {
                    user = Long.parseLong(line.split("\\s+")[1]);
                    nice = Long.parseLong(line.split("\\s+")[2]);
                    system = Long.parseLong(line.split("\\s+")[3]);
                    idle = Long.parseLong(line.split("\\s+")[4]);
                    iowait = Long.parseLong(line.split("\\s+")[5]);
                    irq = Long.parseLong(line.split("\\s+")[6]);
                    softirq = Long.parseLong(line.split("\\s+")[7]);
                    break;
                }
            }
            //获取单进程CPU时间
            List<String> results2 = runCommand(String.format("adb shell cat /proc/%s/stat", pid));
            String line = results2.get(0).trim();
            utime = Long.parseLong(line.split("\\s+")[13]);
            stime = Long.parseLong(line.split("\\s+")[14]);
            cutime = Long.parseLong(line.split("\\s+")[15]);
            cstime = Long.parseLong(line.split("\\s+")[16]);

            CPUInfo cpuInfo = new CPUInfo(user, nice, system, idle, iowait, irq, softirq, utime, stime, cutime, cstime);
            return cpuInfo;
        } catch (Exception e) {
            log(">>>>>>>>>> 获取CPU数据出错");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据一定的时间间隔，计算CPU使用率
     *
     * @param pid      进程PID
     * @param interval 两次取样的时间间隔
     * @return 0：整体CPU使用率；1：APP的CPU使用率
     */
    public List<String> getCPURates(String pid, int interval) {
        try {
            CPUInfo cpuInfo = getCPUInfo(pid);
            cpuInfo.calculateCPUTime();
            Thread.sleep(interval);
            CPUInfo cpuInfo2 = getCPUInfo(pid);
            cpuInfo2.calculateCPUTime();
            //计算总体CPU使用率
            DecimalFormat df = new DecimalFormat("######0.00");
            double totalCPURate = (100 * (double) ((cpuInfo2.getTotalCPUTime() - cpuInfo2.getIdle()) - (cpuInfo.getTotalCPUTime() - cpuInfo.getIdle()))) / ((double) (cpuInfo2.getTotalCPUTime() - cpuInfo.getTotalCPUTime()));
            String totalCPURateStr = df.format(Math.abs(totalCPURate));
            double appCPURate = (100 * (double) (cpuInfo2.getAppCPUTime() - cpuInfo.getAppCPUTime())) / ((double) (cpuInfo2.getTotalCPUTime() - cpuInfo.getTotalCPUTime()));
            String appCPURateStr = df.format(Math.abs(appCPURate));
            List<String> rates = new ArrayList<>();
            rates.add(0, totalCPURateStr);
            rates.add(1, appCPURateStr);
            return rates;
        } catch (Exception e) {
            log(">>>>>>>>>> 计算CPU使用率出错");
            e.printStackTrace();
            return null;
        }

    }

}
