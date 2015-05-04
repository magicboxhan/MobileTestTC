package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/13.
 * 电影票 - 座位选择页面
 */
public class MovieSeatSelectPage extends CommonPage {

    public int pageType = 0; //1：带选好了按钮，2：不带选好了按钮

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public MovieSeatSelectPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    //===== 不带“选好了”按钮 =====

    /**
     * div - 座位列表
     */
    public WebElement divSeatMap() {
        return d.findElement(By.id("seat_map"));
    }

    /**
     * div - 可用座位
     *
     * @param row 行数
     * @param col 列数
     */
    public WebElement divSeat2(int row, int col) {
        return divSeatMap().findElements(By.className("seatCharts-row")).get(row + 2).findElements(By.className("available")).get(col);
    }

    /**
     * a - 下一步
     */
    public WebElement aToPayment() {
        return d.findElement(By.id("topayment"));
    }

    /**
     * div - moviesetcharmsg (填写取票收集号码)
     * @return
     */
    public WebElement divMoviesetcharmsg() {
        return d.findElement(By.id("moviesetcharmsg"));
    }

    /**
     * a - 确认选座
     */
    public WebElement aConfirm() {
        return divMoviesetcharmsg().findElement(By.className("tccheckout-button"));
    }


    //===== 带“选好了”按钮 =====

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
     * div - 可用座位
     * @param row 行数
     * @param col 列数
     */
    public WebElement divSeat1(int row, int col) {
        return divSeatTable().findElements(By.className("row")).get(row + 1).findElements(By.className("available")).get(col);
    }








    //==================== Functions ====================

    /**
     * 切换到iframe
     */
    public void funcSwitchToIFrame(){
        d.switchTo().frame(iframeSeatSelect());
    }

    /**
     * 判断当前页面类型
     * @return 0：异常，1：带“选好了”按钮，2：不带“选好了”按钮
     */
    public int funcGetPageType() {
        try {
            //不到选好了按钮
            aToPayment();
            pageType = 2;
        } catch (Exception e) {
            try {
                //带选好了按钮
                funcSwitchToIFrame();
                spanSelect();
                pageType = 1;
            } catch (Exception e1) {
                //Do nothing
            }
        }
        return pageType;
    }

    /**
     * 选择座位并提交 -- 不带“选好了”按钮的页面
     *
     * @param row 行数
     * @param col 列数
     */
    public void funcSelectSeat(int row, int col) throws InterruptedException {
        if(pageType == 1){
            //带选好了按钮
//            funcSwitchToIFrame();   //已经切过了，不用再切了
            t.log(String.format("Seat title: %s", divSeat1(row, col).getAttribute("title")));
            divSeat1(row, col).click();
            Actions act = new Actions(d);
            act.moveToElement(spanSelect()).click().perform(); //用Actions点击
//            spanSelect().click();
        }else if(pageType == 2) {
            //不带选好了按钮
            t.log(String.format("Seat title: %s", divSeat2(row, col).getAttribute("title")));
            divSeat2(row, col).click();
            aToPayment().click();
            Thread.sleep(5000);
            for (String context : d.getContextHandles()) {
                t.log(String.format("Context: [%s]", context));
            }
            aConfirm().click();
        }
    }

}
