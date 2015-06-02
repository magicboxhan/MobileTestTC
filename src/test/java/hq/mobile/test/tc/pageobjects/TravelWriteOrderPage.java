package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/5/22.
 * 周边游订单填写页
 */
public class TravelWriteOrderPage extends CommonPage{

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public TravelWriteOrderPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return buttonCommit();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Button -- 提交订单
     */
    public WebElement buttonCommit() {
        return d.findElementById("com.tongcheng.android:id/btn_travel_order_commit");
    }

    /**
     * TextView集合 -- 选择游玩日期
     */
    public List<WebElement> textViewTravelCalendar() {
        return d.findElementsById("com.tongcheng.android:id/rl_date");
    }

//    /**
//     * TextView -- 查看套餐价格日历
//     */
//    public WebElement textViewHotelCalendar() {
//        try {
//            return d.findElementById("com.tongcheng.android:id/tv_hotel_start_date");
//        }catch (Exception e){
//            return null;
//        }
//    }

    /**
     * EditText -- 出游人姓名
     */
    public WebElement editTextName() {
        return d.findElementById("com.tongcheng.android:id/et_tourist_name");
    }

    /**
     * EditText -- 出游人手机号
     */
    public WebElement editTextPhone() {
        return d.findElementById("com.tongcheng.android:id/et_tourist_mobile");
    }

    /**
     * EditText -- 出游人身份证号
     */
    public WebElement editTextIDCard() {
        return d.findElementById("com.tongcheng.android:id/et_tourist_identity_card");
    }





    //==================== Functions ====================

    /**
     * 填写订单
     * @param name 姓名
     * @param phone 电话
     * @param idCard 身份证
     * @param isMultiHotel 是否多酒店（0：否，1：是）
     * @throws InterruptedException
     */
    public void funcWriteOrder(String name, String phone, String idCard, int isMultiHotel) throws InterruptedException {
        t.log("从日历选择日期");
        if (isMultiHotel == 0) {
            funcSelectDateFromCalendar();
        } else if(isMultiHotel == 1){
            funcSwipeUp();
        }
        funcSwipeUp();
        t.log("填写出游人信息");
        editTextName().clear();
        editTextName().sendKeys(name);
        editTextPhone().clear();
        editTextPhone().sendKeys(phone);
        try{
            editTextIDCard().clear();
            editTextIDCard().sendKeys(idCard);
        }catch (Exception e){
            //Do nothing
        }
        t.log("提交订单");
        buttonCommit().click();
    }

    /**
     * 选择日历（从第二个链接开始一次选择，第一个链接默认选好了）
     * @throws InterruptedException
     */
    public void funcSelectDateFromCalendar() throws InterruptedException {
        for (int i=1; i<textViewTravelCalendar().size(); i++){
            t.log("点击选择游玩日期");
            textViewTravelCalendar().get(i).click();
//            textViewCalendarCell(0, 0, 0).click();
            textViewCalendarCellAvailable().click();
        }
    }
}
