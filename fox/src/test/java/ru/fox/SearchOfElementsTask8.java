package ru.fox;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeSelected;

/**
 * Created by fomina.zhanna on 31.05.2017.
 */

public class SearchOfElementsTask8 {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void task8() {
        driver.navigate().to("http://localhost/litecart");

        // ищем вкладки
        List<WebElement> tabs;
        tabs = driver.findElements(By.cssSelector(".nav-tabs li a"));

        // проходим по всем вкладкам
        for (WebElement tab : tabs) {

            // кликаем по вкладке
            tab.click();

            // проверяем, что вкладка выбрана
            elementToBeSelected(tab);

            // ищем товары
            // проверяем, что они есть
            List<WebElement> ducks;
            ducks = driver.findElements(By.cssSelector(".product"));

            assertTrue("Товаров нет", ducks.size() > 0);

            // ищем стикеры
            // проверяем, что каждый товар имеет один стикер
            List<WebElement> stickers;
            String name;

            for (WebElement duck : ducks) {
                name = duck.findElement(By.cssSelector(".name")).getText();
                System.out.println(name);
                stickers = duck.findElements(By.cssSelector(".sticker"));
                assertEquals("Товар с некорректным количеством стикеров: " + name, 1, stickers.size());
            }
        }
    }

    @After
    public void stop()
    {
        driver.quit();
        driver = null;
    }
}


