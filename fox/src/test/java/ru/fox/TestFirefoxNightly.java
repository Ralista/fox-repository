package ru.fox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by fomina.zhanna on 24.05.2017.
 */
public class TestFirefoxNightly {
    public WebDriver driver;

    @Before
    public void start(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, true);
        driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Users\\fomina.zhanna\\Mozilla Firefox Nightly\\firefox.exe")), new FirefoxProfile(), caps);
    }

    @Test
    public void nightly(){
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