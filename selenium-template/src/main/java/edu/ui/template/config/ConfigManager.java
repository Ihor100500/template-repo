package edu.ui.template.config;

import java.io.InputStream;
import java.util.Properties;
import lombok.Getter;

@Getter
public class ConfigManager {

  private static ConfigManager instance;
  private final Properties properties;

  private ConfigManager() {
    properties = new Properties();
    try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
      properties.load(input);
    } catch (Exception e) {
      throw new RuntimeException("Failed to load config.properties", e);
    }
  }

  public static synchronized ConfigManager getInstance() {
    if (instance == null) {
      instance = new ConfigManager();
    }
    return instance;
  }

  public String getBaseUrl() {
    return properties.getProperty("base.url");
  }

  public String isMobileEmulation() {
    return properties.getProperty("mobile.emulation");
  }

  public String getAndroidDeviceName() {
    return properties.getProperty("device.name");
  }

  public String getAndroidAppPath() {
    return properties.getProperty("device.path");
  }

  public String getBrowser() {
    return properties.getProperty("browser");
  }
}
