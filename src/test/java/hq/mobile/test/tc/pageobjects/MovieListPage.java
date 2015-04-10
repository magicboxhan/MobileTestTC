package hq.mobile.test.tc.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by hq11258 on 2015/4/10.
 */
public class MovieListPage extends CommonPage {

    /**
     * 构造方法
     * @param d 驱动
     */
    public MovieListPage(AppiumDriver d){
        super(d);
    }

    //==================== Elements ====================

    /**
     * ul - 影片列表
     */
    public WebElement ulMovieList() {
        return d.findElement(By.className("movie_list"));
    }

    /**
     * li集合 - 影片
     * @return
     */
    public List<WebElement> liMovie(){
        return ulMovieList().findElements(By.tagName("li"));
    }

    /**
     * li - 影片
     * @param index 索引
     */
    public WebElement liMovie(int index){
        return liMovie().get(index);
    }


    //==================== Functions ====================
}
