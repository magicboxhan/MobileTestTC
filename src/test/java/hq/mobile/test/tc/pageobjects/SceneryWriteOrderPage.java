package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
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
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return buttonSubmitOrder();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * TextView集合 -- 点击选择日期
     */
    public List<WebElement> textViewSelectDate() {
        return d.findElementsById("com.tongcheng.android:id/tv_date");
    }

//    /**
//     * TextView -- 点击选择日期
//     */
//    public WebElement textViewSelectDate() {
//        return d.findElementById("com.tongcheng.android:id/tv_date");
//    }

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

    /**
     * Button -- 提交订单
     */
    public WebElement buttonForceSubmit() {
        return d.findElementById("com.tongcheng.android:id/btn_dialog_left");
    }

    //==================== Functions ====================

    /**
     * 填写订单并提交
     *
     * @param name  取票人姓名
     * @param phone 取票人手机号
     * @param card  取票人证件号
     */
    public void funcSubmitOrder(String name, String phone, String card) throws InterruptedException {
        //选择日期
        for (int i = 0; i < textViewSelectDate().size(); i++) {
            textViewSelectDate().get(i).click();
            textViewCalendarCellAvailable().click();
        }
        funcSwipeUp();
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
        try{
            Thread.sleep(2000);
            buttonForceSubmit().click();
        }catch(Exception e){
            //Do nothing
        }
    }

}
