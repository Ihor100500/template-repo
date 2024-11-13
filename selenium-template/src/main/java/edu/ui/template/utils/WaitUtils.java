package edu.ui.template.utils;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitUtils {
  private static final int TIMEOUT = 10; // Default timeout

  public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
    return fluentWait(driver).until(ExpectedConditions.elementToBeClickable(element));
  }

  public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) {
    return fluentWait(driver).until(ExpectedConditions.visibilityOf(element));
  }

  public static Wait<WebDriver> fluentWait(WebDriver driver) {
    return new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(TIMEOUT))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(NoSuchElementException.class);
  }
}
