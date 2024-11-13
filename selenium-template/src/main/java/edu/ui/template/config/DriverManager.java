package edu.ui.template.config;

import static edu.ui.template.config.mobile.MobileDriver.createAndroidDriver;
import static edu.ui.template.config.web.WebChromeDriver.createChromeDriver;

import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class DriverManager {

  private WebDriver webChromedriver;
  private AndroidDriver androidDriver;

  private static DriverManager instance;

  private DriverManager() {}

  public static DriverManager getInstance() {
    if (instance == null) {
      instance = new DriverManager();
    }
    return instance;
  }

  public void setUp() {
    if (Boolean.parseBoolean(ConfigManager.getInstance().isMobileEmulation())) {
      androidDriver = createAndroidDriver();
    } else {
      webChromedriver = createChromeDriver();
    }
  }

  public void quitDriver() {
    if (androidDriver != null) {
      androidDriver.quit();
    }
    if (webChromedriver != null) {
      webChromedriver.quit();
    }
  }
}
