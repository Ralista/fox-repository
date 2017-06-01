package ru.fox;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by fomina.zhanna on 29.05.2017.
 */

public class SearchOfElementsTask7 {
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    private void wait_and_check_h1(){
        // ждем и проверяем, что на странице видно тег h1
        WebElement element = wait.until(visibilityOfElementLocated(By.cssSelector("h1")));
    }

    @Test
    public void task7(){
        // проходим авторизацию
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.cssSelector(".btn[name=login]")).click();

        // ждём появление элемента
        WebElement element = wait.until(presenceOfElementLocated(By.cssSelector("#chart-sales-monthly")));

        int cnt_menu = driver.findElements(By.cssSelector("#box-apps-menu li#app-")).size();

        // проходим по всем элементам меню
        for (int i = 0; i < cnt_menu; i++){
            WebElement item =  driver.findElements(By.cssSelector("#box-apps-menu li#app-")).get(i);
            System.out.println("* " + item.getText());

            // кликаем по элементу меню
            item.click();

            wait_and_check_h1();

            // проверяем, что элемент выбран
            elementToBeSelected(item);

            // получаем подэлементы элемента меню
            // ищем выбранный элемент меню и берём все подэлементы
            int cnt_submenu  = driver.findElements(By.cssSelector("#box-apps-menu li.selected .docs li")).size();

            // если есть подэлементы меню, то кликаем по каждому из них
            if (cnt_submenu != 0) {
                for (int y = 0; y < cnt_submenu; y++){
                    WebElement sub_item = driver.findElements(By.cssSelector(String.format("#box-apps-menu li.selected .docs li"))).get(y);
                    System.out.println("   - " + sub_item.getText());

                    // кликаем по подэлементу
                    sub_item.click();

                    wait_and_check_h1();

                    // проверяем, что элемент выбран
                    elementToBeSelected(item);
                }
            } else {
                System.out.println("   .");
                driver.findElement(By.cssSelector("h1"));
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