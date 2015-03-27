package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by hanqing on 2015/3/27.
 * 搜索页 *
 */
public class SearchPage extends CommonPage {
    
    public SearchPage(AppiumDriver d){
        super(d);
    }

    //==================== Elements ====================

    /**
     * ImageView -- 后退 *
     */
    public WebElement imageViewBack(){
        return d.findElementById("com.tongcheng.android:id/actionbar_back");
    }

    /**
     * EditText -- 搜索关键字 *
     */
    public WebElement EditTextKeyword(){
        return d.findElementById("com.tongcheng.android:id/keyword");
    }

    /**
     * TextView -- 结果名称（根据索引） *
     * @param index 索引
     */
    public WebElement textViewName(int index){
        try {
            return d.findElementsById("com.tongcheng.android:id/name").get(index);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * TextView -- 结果包含数量（根据索引） *
     * @param index 索引
     */
    public WebElement textViewCount(int index){
        try {
            return d.findElementsById("com.tongcheng.android:id/count").get(index);
        }catch (Exception e){
            return null;
        }
    }

    //==================== Functions ====================
    
    
}
