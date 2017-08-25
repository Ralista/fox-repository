package ru.fox;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by fomina.zhanna on 24.07.2017.
 */

public class RegistrationTask11 {
    private static WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    public static WebElement getElementByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                return element;
            }
        }
        Assert.fail("Элемент не найден.");
        return null;
    }

    @Test
    public void task11() {
        driver.navigate().to("http://localhost/litecart/en/");

        String uniqueEmail = UUID.randomUUID() + "@gmail.com";

        clickLink();
        typeTaxId();
        typeCompany();
        typeFirstName();
        typeLastName();
        typeAddress1();
        typeAddress2();
        typePostCode();
        typeCity();
        clickCountry();
        selectCountry();
        clickZone();
        selectZone();
        typeEmail(uniqueEmail);
        typePhone();
        typePassword();
        confirmPassword();
        clickCreateAccount();
        clickLogout();
        SignInEmail(uniqueEmail);
        SignInPassword();
        clickSignIn();
        clickLogout();
    }

    //Кликаем по ссылке
    @Step
    public static void clickLink() {
        List<WebElement> elements;
        elements = driver.findElements(By.cssSelector("[class='text-center']"));
        WebElement link = getElementByText(elements, "New customers click here");
        link.click();
    }

    //Заполняем Tax ID
    @Step
    public static void typeTaxId() {
        WebElement taxId = driver.findElement(By.cssSelector("#box-create-account [name='tax_id']"));
        taxId.sendKeys("80808");
    }

    //Заполняем Company
    @Step
    public static void typeCompany() {
        WebElement company = driver.findElement(By.cssSelector("#box-create-account [name='company']"));
        company.sendKeys("SnowFox");
    }

    //Заполняем Firstname
    @Step
    public static void typeFirstName() {
        WebElement firstName = driver.findElement(By.cssSelector("#box-create-account [name='firstname']"));
        firstName.sendKeys("Joanna");
    }

    //Заполняем Lastname
    @Step
    public static void typeLastName() {
        WebElement lastName = driver.findElement(By.cssSelector("#box-create-account [name='lastname']"));
        lastName.sendKeys("Yefimova");
    }

    //Заполняем Address 1
    @Step
    public static void typeAddress1() {
        WebElement address1 = driver.findElement(By.cssSelector("#box-create-account [name='address1']"));
        address1.sendKeys("Nordwood Drive");
    }

    //Заполняем Address 2
    @Step
    public static void typeAddress2() {
        WebElement address2 = driver.findElement(By.cssSelector("#box-create-account [name='address2']"));
        address2.sendKeys("Blue Street");
    }

    //Заполняем Postcode
    @Step
    public static void typePostCode() {
        WebElement postCode = driver.findElement(By.cssSelector("#box-create-account [name='postcode']"));
        postCode.sendKeys("60606");
    }

    //Заполняем City
    @Step
    public static void typeCity() {
        WebElement city = driver.findElement(By.cssSelector("#box-create-account [name='city']"));
        city.sendKeys("Anchorage");
    }

    //Кликаем по Country
    @Step
    public static void clickCountry() {
        WebElement country = driver.findElement(By.cssSelector("#box-create-account [name='country_code']"));
        country.click();
    }

    //Выбираем Country
    @Step
    public static void selectCountry() {
        List<WebElement> elements;
        elements = driver.findElements(By.cssSelector("[class='form-control']"));
        WebElement country = driver.findElement(By.cssSelector("[value='US']"));
        country.click();
    }

    //Кликаем по Zone/State/Province
    @Step
    public static void clickZone() {
        WebElement zone = driver.findElement(By.cssSelector("#box-create-account [name='zone_code']"));
        zone.click();
    }

    //Выбираем Zone/State/Province
    @Step
    public static void selectZone() {
        List<WebElement> elements;
        elements = driver.findElements(By.cssSelector("[class='form-control']"));
        WebElement zone = driver.findElement(By.cssSelector("[value='AK']"));
        zone.click();
    }

    //Заполняем Email
    @Step
    public static void typeEmail(String uniqueEmail) {
        WebElement email = driver.findElement(By.cssSelector("#box-create-account [name='email']"));
        email.sendKeys(uniqueEmail);
    }

    //Заполняем Phone
    @Step
    public static void typePhone() {
        WebElement phone = driver.findElement(By.cssSelector("#box-create-account [name='phone']"));
        phone.sendKeys("+7-966-182-82-98");
    }

    //Заполняем Desired Password
    @Step
    public static void typePassword() {
        WebElement password = driver.findElement(By.cssSelector("#box-create-account [name='password']"));
        password.sendKeys("~J4a$6");
    }

    //Заполняем Confirm Password
    @Step
    public static void confirmPassword() {
        WebElement confirmedPassword = driver.findElement(By.cssSelector("#box-create-account [name='confirmed_password']"));
        confirmedPassword.sendKeys("~J4a$6");
    }

    //Нажимаем на Create Account
    @Step
    public static void clickCreateAccount() {
        WebElement button = driver.findElement(By.cssSelector("#box-create-account [name='create_account']"));
        button.click();
    }

    //Нажимаем на Logout
    @Step
    public static void clickLogout() {
        List<WebElement> elements;
        elements = driver.findElements(By.cssSelector("#box-account a"));
        WebElement logout = getElementByText(elements, "Logout");
        logout.click();
    }

    //Sign In
    @Step
    public static void SignInEmail(String uniqueEmail) {
        WebElement email = driver.findElement(By.cssSelector("#box-account-login [name='email']"));
        email.sendKeys(uniqueEmail);
    }

    //Sign In
    @Step
    public static void SignInPassword() {
        WebElement password = driver.findElement(By.cssSelector("#box-account-login [name='password']"));
        password.sendKeys("~J4a$6");
    }

    //Нажимаем на Sign In
    @Step
    public static void clickSignIn() {
        WebElement button = driver.findElement(By.cssSelector("#box-account-login [name='login']"));
        button.click();
    }
}



