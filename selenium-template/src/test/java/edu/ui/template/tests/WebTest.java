package edu.ui.template.tests;

import static org.assertj.core.api.Assertions.assertThat;

import edu.ui.template.base.BaseTest;
import edu.ui.template.config.ConfigManager;
import edu.ui.template.utils.WaitUtils;
import edu.ui.template.utils.WebElementActions;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebTest extends BaseTest {

  @Test
  public void browserTest() {
    WebElementActions actions = new WebElementActions(chromeDriver);
    chromeDriver.get(ConfigManager.getInstance().getBaseUrl());
    WebElement webElement =
        WaitUtils.waitForVisibilityOfElement(
            chromeDriver,
            chromeDriver.findElement(
                By.xpath("//div[@id='HSBC_GDPR_EXPLICIT_COOKIE_CONSENT-describe']")));
    if (webElement.isDisplayed()) {
      actions.clickElement(
          chromeDriver.findElement(
              By.xpath(
                  "//button[@class='popup-notification__button popup-notification__button--negative']")));
    }

    actions.clickElement(
        chromeDriver.findElement(By.xpath("//a[@data-navigation-item-name='Investors']")));

    WaitUtils.fluentWait(chromeDriver)
        .until(
            ExpectedConditions.attributeToBe(
                By.xpath("//a[@data-navigation-item-name='Investors']"), "aria-expanded", "true"));

    List<WebElement> investorsList =
        chromeDriver.findElements(
            By.xpath("//div[@class='nav-group']//ul[@aria-label='Investors']/li"));

    WebElement resultAndAnnouncmentsElement =
        investorsList.stream()
            .filter(el -> Objects.equals(el.getText().trim(), "Results and announcements"))
            .findFirst()
            .orElseThrow();

    resultAndAnnouncmentsElement.click();
    // some waiter here
    chromeDriver
        .findElements(By.xpath("//ul[@aria-label='Results and announcements']/li/a"))
        .stream()
        .filter(el -> Objects.equals(el.getText().trim(), "All reporting"))
        .findFirst()
        .orElseThrow()
        .click();

    WaitUtils.waitForVisibilityOfElement(
        chromeDriver,
        chromeDriver.findElement(By.xpath("//h1[contains(text(), 'All reporting') ]")));

    // still think regarding 2024
    actions.scrollToElement(
        chromeDriver.findElement(
            By.xpath("//div[@class='row']//caption[contains(text(), '2024')]")));

    // pop-up
    WaitUtils.waitForVisibilityOfElement(
        chromeDriver, chromeDriver.findElement(By.xpath("//div[@class='popups__overlay']")));
    if (chromeDriver.findElement(By.xpath("//div[@class='popups__overlay']")).isDisplayed()) {
      actions.clickElement(
          chromeDriver.findElement(By.xpath("//button[contains(text(), 'Okay, got it')]")));
    }

    List<WebElement> dateColumnValues =
        chromeDriver.findElements(By.xpath("//div[@class='table-cell-mobile']")).stream()
            .filter(el -> el.getAttribute("textContent").trim().contains("Date:"))
            .toList();

    assertThat(dateColumnValues.get(3).getText()).isEqualTo("07 Aug 2024");
  }
}
