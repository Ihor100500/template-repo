package edu.ui.template.tests;

import edu.ui.template.base.BaseTest;
import edu.ui.template.config.ConfigManager;
import org.junit.jupiter.api.Test;

public class WebTest extends BaseTest {

  @Test
  public void browserTest() {
    chromeDriver.get(ConfigManager.getInstance().getBaseUrl());
  }
}
