package edu.ui.template.base;

import edu.ui.template.config.ConfigManager;
import edu.ui.template.config.DriverManager;
import edu.ui.template.config.mobile.AppiumManager;
import io.appium.java_client.android.AndroidDriver;
import java.util.Objects;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

  protected WebDriver chromeDriver;
  protected AndroidDriver androidDriver;

  @BeforeAll
  public static void setupService() {
    if (Boolean.parseBoolean(ConfigManager.getInstance().isMobileEmulation())) {
      AppiumManager.getInstance().startService();
    }
  }

  @BeforeEach
  public void setup() {
    DriverManager.getInstance().setUp();
    // to be refactored as confusing which browser instantiated actually
    if (Objects.isNull(DriverManager.getInstance().getWebChromedriver())) {
      androidDriver = DriverManager.getInstance().getAndroidDriver();
    } else {
      chromeDriver = DriverManager.getInstance().getWebChromedriver();
    }
  }

  @AfterEach
  public void quit() {
    DriverManager.getInstance().quitDriver();
  }

  @AfterAll
  public static void tearDown() {
    AppiumManager.getInstance().stopService();
  }
}
