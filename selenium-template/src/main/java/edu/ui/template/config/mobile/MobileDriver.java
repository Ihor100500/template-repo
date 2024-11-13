package edu.ui.template.config.mobile;

import edu.ui.template.config.ConfigManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URI;

public class MobileDriver {

  private MobileDriver() {}

  public static AndroidDriver createAndroidDriver() {
    UiAutomator2Options options = getUiAutomator2Options();
    try {
      return new AndroidDriver(URI.create("http://127.0.0.1:4723/").toURL(), options);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  private static UiAutomator2Options getUiAutomator2Options() {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setDeviceName(ConfigManager.getInstance().getAndroidDeviceName());
    options.setChromedriverExecutable("src/test/resources/chromedriver.exe");
    options.setApp(ConfigManager.getInstance().getAndroidAppPath());
    return options;
  }
}
