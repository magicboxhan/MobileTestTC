package hq.mobile.test.tc.monkey;

import hq.mobile.test.tc.utils.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hq11258 on 2015/6/9.
 * monkey测试工具类
 */
public class MonkeyUtil {

    public String cmd;              //执行命令
    public List<String> log;        //控制台输出 -- 全部
    public List<String> crash;      //控制台输出 -- 崩溃
    public List<String> anr;        //控制台输出 -- 无响应
    public String seed;             //执行seed
    public String logcat;           //logcat
    protected Tools t = new Tools();

    public MonkeyUtil(String cmd) {
        this.cmd = cmd;
    }

    // 收集shell脚本运行的结果集
    public static List<String> getShellResult(Process process) {
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

        return output;
    }

    public void runMonkey() throws IOException {
        Process p = Runtime.getRuntime().exec(cmd);
        log = getShellResult(p);
        analyzeLog();
    }

    //分析日志
    public void analyzeLog() {
        for (String line : log) {
            //crash
            if (line.toLowerCase().contains("crash")) {
                crash.add(line);
            }
            //anr

            //seed
            if (line.toLowerCase().contains("seed=")) {
                seed = line.split("seed=")[1].split(" ")[0];
            }
        }
    }

    /**
     * 输出日志
     *
     * @param output
     */
    public void print(List<String> output) {
        if (output != null) {
            for (String line : output) {
                t.log(line);
            }
        }
    }

    public void printLog() {
        print(log);
    }

    public void printCrash() {
        print(crash);
    }

    public void printSeed() {
        t.log(seed);
    }
}
