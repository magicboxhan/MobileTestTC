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
     * div - 座位列表
     */
    public WebElement divSeatMap() {
        return d.findElement(By.id("seat_map"));
    }

    /**
     * div - 可用座位
     * @param row 行数
     * @param col 列数
     */
    public WebElement divSeat(int row, int col) {
        return divSeatMap().findElements(By.className("seatCharts-row")).get(row + 2).findElements(By.className("available")).get(col);
    }

    /**
     * a - 下一步
     */
    public WebElement aToPayment() {
        return d.findElement(By.id("topayment"));
    }

    /**
     * a - 确认选座
     */
    public WebElement aConfirm() {
        return d.findElement(By.className("tccheckout-button"));
    }




    /**
     * iframe - 座位列表
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

    //==================== Functions ====================

    /**
     * 选择座位并提交
     * @param row 行数
     * @param col 列数
     */
    public void funcSelectSeat(int row, int col) throws InterruptedException {
        divSeat(row, col).click();
        aToPayment().click();
        Thread.sleep(2000);
        aConfirm().click();
    }

}
