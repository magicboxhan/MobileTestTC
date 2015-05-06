package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/28.
 * 景点订单填写页
 */
public class SceneryWriteOrderPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public SceneryWriteOrderPage(AppiumDriver d) {
        super(d);
    }

    //==================== Elements ====================

    /**
     * TextView -- 点击选择日期
     */
    public WebElement textViewSelectDate() {
        return d.findElementById("com.tongcheng.android:id/tv_date");
    }

    /**
     * TextView -- 根据文字获取控件
     *
     * @param name 文字
     */
    public WebElement textViewDate(String name) {
        return d.findElementByName(name);
    }

    /**
     * EditText -- 取票人姓名
     */
    public WebElement editTextGetTicketName() {
        return d.findElementById("com.tongcheng.android:id/et_getticket_name");
    }

    /**
     * EditText -- 取票人手机号
     */
    public WebElement editTextGetTicketPhone() {
        return d.findElementById("com.tongcheng.android:id/et_getticket_phone");
    }

    /**
     * EditText -- 取票人身份证号
     */
    public WebElement editTextGetTicketCard() {
        return d.findElementById("com.tongcheng.android:id/et_getticket_card");
    }

    /**
     * Button -- 提交订单
     */
    public WebElement buttonSubmitOrder() {
        return d.findElementById("com.tongcheng.android:id/btn_submit_order");
    }

    //==================== Functions ====================

    /**
     * 填写订单并提交
     *
     * @param name  取票人姓名
     * @param phone 取票人手机号
     * @param card  取票人证件号
     * @param month 要选择的日历中的月份索引（从0开始）
     * @param week  要选择的日历中的周索引（从0开始）
     * @param day   要选择的日历中的日期索引（从0开始）
     */
    public void funcSubmitOrder(String name, String phone, String card, int month, int week, int day) {
        //选择日期
        textViewSelectDate().click();
        textViewCalendarCell(month, week, day).click();
        //取票人姓名
        editTextGetTicketName().clear();
        editTextGetTicketName().sendKeys(name);
        //取票人手机号
        editTextGetTicketPhone().clear();
        editTextGetTicketPhone().sendKeys(phone);
        //取票人身份证号
        editTextGetTicketCard().clear();
        editTextGetTicketCard().sendKeys(card);
        //点击提交按钮
        buttonSubmitOrder().click();
    }

}
