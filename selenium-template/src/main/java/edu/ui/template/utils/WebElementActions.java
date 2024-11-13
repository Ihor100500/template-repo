package edu.ui.template.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementActions {
  private final WebDriver driver;

  public WebElementActions(WebDriver driver) {
    this.driver = driver;
  }

  public void clickElement(WebElement element) {
    WaitUtils.waitForElementToBeClickable(driver, element).click();
  }

  public void scrollToElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public void clickUsingJavaScript(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
  }
}
