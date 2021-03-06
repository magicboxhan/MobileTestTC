package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/10.
 * 电影票 - 电影选择页面
 */
public class MovieListPage extends CommonPage {

    /**
     * 构造方法
     *
     * @param d 驱动
     */
    public MovieListPage(AppiumDriver d) {
        super(d);
        checkKeyElement = true;
    }

    //==================== Elements ====================

    public WebElement keyElement() {
        try {
            return liMovie().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ul - 影片列表
     */
    public WebElement ulMovieList() {
        return d.findElement(By.className("movie_list"));
    }

    /**
     * li集合 - 影片
     */
    public List<WebElement> liMovie() {
        return ulMovieList().findElements(By.tagName("li"));
    }

    /**
     * li - 影片
     *
     * @param index 索引
     */
    public WebElement liMovie(int index) {
        return liMovie().get(index);
    }


    //==================== Functions ====================
}
