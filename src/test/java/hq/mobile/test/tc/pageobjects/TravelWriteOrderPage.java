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

    public void funcWriteOrder(String name, String phone, String idCard) throws InterruptedException {
        t.log("从日历选择日期");
        funcSelectDateFromCalendar();
        t.log("向上滑动页面");
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

    public void funcSelectDateFromCalendar() throws InterruptedException {


        for (int i=1; i<textViewTravelCalendar().size(); i++){
            t.log("点击选择游玩日期");
            textViewTravelCalendar().get(i).click();
            textViewCalendarCell(0, 0, 0).click();
        }

//        //如果存在旅游日历链接
//        if (textViewTravelCalendar().size() > 0){
//            t.log("点击选择游玩日期");
//            textViewTravelCalendar().get(0).click();
//            textViewCalendarCell(1, 0, 0).click();
//        }

//        //如果存在酒店日历链接
//        if (textViewHotelCalendar() != null){
//            t.log("查看套餐价格日历");
//            textViewHotelCalendar().click();
//            textViewCalendarCell(1, 0, 0).click();
//            for (WebElement e :textViewTravelCalendar()){
//                t.log("选择价格套餐日历后，点击选择游玩日期");
//                e.click();
//                textViewCalendarCell(0, 0, 0).click();
//            }
//        }

    }
}
