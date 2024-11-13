package edu.ui.template.tests;

import static edu.ui.template.utils.WaitUtils.fluentWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import edu.ui.template.base.BaseTest;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

public class MobileTest extends BaseTest {

  @Test
  public void hybridModeTest() {
    fluentWait(androidDriver)
        .until(
            presenceOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")));
  }
}
