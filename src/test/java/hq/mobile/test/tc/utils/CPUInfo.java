package hq.mobile.test.tc.utils;

/**
 * Created by hq11258 on 2015/9/19.
 * 内存信息实体
 */
public class CPUInfo {

    //总体CPU参数
    long user;      //从系统启动开始累计到当前时刻，处于用户态的运行时间，不包含 nice 值为负进程
    long nice;      //从系统启动开始累计到当前时刻，nice 值为负的进程所占用的CPU时间
    long system;    //从系统启动开始累计到当前时刻，处于核心态的运行时间
    long idle;      //从系统启动开始累计到当前时刻，除 IO 等待时间以外的其它等待时间
    long iowait;    //从系统启动开始累计到当前时刻，IO 等待时间
    long irq;       //从系统启动开始累计到当前时刻，硬中断时间
    long softirq;   //从系统启动开始累计到当前时刻，软中断时间

    //单进程CPU参数
    long utime;     //该任务在用户态运行的时间
    long stime;     //该任务在核心态运行的时间
    long cutime;    //所有已死线程在用户态运行的时间
    long cstime;    //所有已死在核心态运行的时间

    //计算结果
    long totalCPUTime;      //总体CPU时间
    long appCPUTime;        //单进程CPU时间
    double totalCPURate;    //总体CPU使用率
    double appCPURate;      //单进程CPU使用率


    public CPUInfo(long user, long nice, long system, long idle, long iowait, long irq, long softirq, long utime, long stime, long cutime, long cstime) {
        this.user = user;
        this.nice = nice;
        this.system = system;
        this.idle = idle;
        this.iowait = iowait;
        this.irq = irq;
        this.softirq = softirq;
        this.utime = utime;
        this.stime = stime;
        this.cutime = cutime;
        this.cstime = cstime;
        totalCPUTime = 0;
        appCPUTime = 0;
        totalCPURate = 0;
        appCPURate = 0;
    }

    //getter and setter
    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getNice() {
        return nice;
    }

    public void setNice(long nice) {
        this.nice = nice;
    }

    public long getSystem() {
        return system;
    }

    public void setSystem(long system) {
        this.system = system;
    }

    public long getIdle() {
        return idle;
    }

    public void setIdle(long idle) {
        this.idle = idle;
    }

    public long getIowait() {
        return iowait;
    }

    public void setIowait(long iowait) {
        this.iowait = iowait;
    }

    public long getIrq() {
        return irq;
    }

    public void setIrq(long irq) {
        this.irq = irq;
    }

    public long getSoftirq() {
        return softirq;
    }

    public void setSoftirq(long softirq) {
        this.softirq = softirq;
    }

    public long getUtime() {
        return utime;
    }

    public void setUtime(long utime) {
        this.utime = utime;
    }

    public long getStime() {
        return stime;
    }

    public void setStime(long stime) {
        this.stime = stime;
    }

    public long getCutime() {
        return cutime;
    }

    public void setCutime(long cutime) {
        this.cutime = cutime;
    }

    public long getCstime() {
        return cstime;
    }

    public void setCstime(long cstime) {
        this.cstime = cstime;
    }

    public long getTotalCPUTime() {
        return totalCPUTime;
    }

    public long getAppCPUTime() {
        return appCPUTime;
    }

    public double getTotalCPURate() {
        return totalCPURate;
    }

    public double getAppCPURate() {
        return appCPURate;
    }

    //计算CPU时间
    public void calculateCPUTime(){
        totalCPUTime = user + nice + system + idle + iowait + irq + softirq;
        appCPUTime = utime + stime + cutime + cstime;
    }
}
