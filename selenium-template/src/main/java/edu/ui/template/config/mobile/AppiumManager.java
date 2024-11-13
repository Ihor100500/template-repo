package edu.ui.template.config.mobile;

import static edu.ui.template.config.mobile.AppiumConfig.createService;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumManager {

  private final AppiumDriverLocalService appiumDriverLocalService;
  private static AppiumManager instance;

  private AppiumManager(AppiumDriverLocalService appiumDriverLocalService) {
    this.appiumDriverLocalService = appiumDriverLocalService;
  }

  public static AppiumManager getInstance() {
    if (instance == null) {
      instance = new AppiumManager(createService());
    }
    return instance;
  }

  public void startService() {
    appiumDriverLocalService.start();
  }

  public void stopService() {
    appiumDriverLocalService.stop();
  }
}
