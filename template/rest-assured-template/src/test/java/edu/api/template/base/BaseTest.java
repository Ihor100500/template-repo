package edu.api.template.base;

import edu.api.template.config.ConfigManager;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

  @BeforeAll
  public static void setup() {
    RestAssured.baseURI = ConfigManager.getInstance().getBaseUrl();
  }
}
