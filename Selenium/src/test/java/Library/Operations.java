package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.Color;


import java.awt.*;
import java.time.Duration;

public class Operations {
    public static WebElement findElement(By path, WebDriver driver) {
        WebElement el = driver.findElement(path);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(path));
        return el;
    }

    public static void click(By locator, WebDriver driver) {
        WebElement el = findElement(locator, driver);
        el.click();
    }
    public static void dropDownByVisibleText(By locator, String text, WebDriver driver) {
        WebElement el = findElement(locator, driver);
        Select dropdown = new Select(el);
        dropdown.selectByVisibleText(text);
    }
    public static void dropDownByValue(By locator, String value, WebDriver driver) {
        WebElement el = findElement(locator, driver);
        Select dropdown = new Select(el);
        dropdown.selectByValue(value);
    }

    public static void sendText(By locator, String text, WebDriver driver){
        WebElement el = findElement(locator, driver);
        el.clear();
        el.sendKeys(text);
    }

    public static void matchText(By locator, String expectedText, WebDriver driver){
        WebElement el = findElement(locator, driver);
        String actualText = el.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public static void matchColor(By locator, String expectedColor, String cssValue, WebDriver driver){
        WebElement el = findElement(locator, driver);
       String actualColor = el.getCssValue(cssValue);
       String hexColor = Color.fromString(actualColor).asHex();
       Assert.assertEquals(hexColor, expectedColor);
    }

    public static void matchAttribute(By locator, String expectedValue, String attributeName, WebDriver driver){
        WebElement el = findElement(locator, driver);
        String actualValue = el.getCssValue(attributeName);
        Assert.assertEquals(actualValue, expectedValue);
    }

    public static void waitUntilElementClickable(By locator, WebDriver driver){
        WebElement el = findElement(locator, driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(el));
    }
    public static void waitUntilElementVisible(By locator, WebDriver driver){
        WebElement el = findElement(locator, driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(el));
    }
    public static void scroll(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
}
