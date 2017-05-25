package ru.fox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by fomina.zhanna on 24.05.2017.
 */
public class TestFirefox {
    public WebDriver driver;

    @Before
    public void start(){
        driver = new FirefoxDriver();
    }

    @Test
    public void firefox(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();
    }

    @After
    public void stop()
    {
        driver.quit();
        driver = null;
    }
}