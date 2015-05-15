package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by hq11258 on 2015/5/14.
 * 爱旅卡页
 */
public class MyAiLvKaPage extends CommonPage {

    public MyAiLvKaPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return spanSubmit();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Span -- 激活
     */
    public WebElement spanSubmit() {
        return d.findElement(By.className("btn-submit"));
    }
}
