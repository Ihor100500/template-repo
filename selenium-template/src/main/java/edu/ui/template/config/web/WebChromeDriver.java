package edu.ui.template.config.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebChromeDriver {

  public static WebDriver createChromeDriver() {
    WebDriverManager.chromedriver().setup();
    ChromeOptions chromeOptions = getChromeOptions();
    return new ChromeDriver(chromeOptions);
  }

  private static ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-infobars");
    return options;
  }
}
