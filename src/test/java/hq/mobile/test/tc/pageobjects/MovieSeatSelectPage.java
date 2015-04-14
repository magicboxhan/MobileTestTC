package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/13.
 * 电影票 - 座位选择页面
 */
public class MovieSeatSelectPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public MovieSeatSelectPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * iframe - 座位选择
     */
    public WebElement iframeSeatSelect() {
        return d.findElement(By.id("framePage"));
    }

    /**
     * span - 选好了
     */
    public WebElement spanSelect() {
        return d.findElement(By.cssSelector(".m-l-right.btn-disable.btn-pick.btn-lock.checkout-btn"));
    }

    /**
     * div - 座位列表
     */
    public WebElement divSeatTable() {
        return d.findElement(By.id("roomPage")).findElement(By.className("room")).findElement(By.className("table"));
    }

    /**
     * div集合 - 可用座位
     */
    public List<WebElement> divSeatsAvailable() {
        return divSeatTable().findElements(By.className("available"));
    }

    /**
     * div集合 - 被锁定座位
     */
    public List<WebElement> divSeatsLocked() {
        return divSeatTable().findElements(By.className("locked"));
    }


    //==================== Functions ====================

}
