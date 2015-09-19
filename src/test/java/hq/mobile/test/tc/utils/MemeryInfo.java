package hq.mobile.test.tc.utils;

/**
 * Created by hq11258 on 2015/9/19.
 * 内存信息实体
 */
public class MemeryInfo {

    String pid;
    String nativePss;
    String dalvikPss;
    String totalPss;

    //构造方法
    public MemeryInfo(String pid, String nativePss, String dalvikPss, String totalPss) {
        this.pid = pid;
        this.nativePss = nativePss;
        this.dalvikPss = dalvikPss;
        this.totalPss = totalPss;
    }

    //getter and setter
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getNativePss() {
        return nativePss;
    }

    public void setNativePss(String nativePss) {
        this.nativePss = nativePss;
    }

    public String getDalvikPss() {
        return dalvikPss;
    }

    public void setDalvikPss(String dalvikPss) {
        this.dalvikPss = dalvikPss;
    }

    public String getTotalPss() {
        return totalPss;
    }

    public void setTotalPss(String totalPss) {
        this.totalPss = totalPss;
    }
}
