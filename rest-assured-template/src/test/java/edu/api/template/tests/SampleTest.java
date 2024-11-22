package edu.api.template.tests;

import static io.restassured.RestAssured.given;

import edu.api.template.base.BaseTest;
import edu.api.template.config.ConfigManager;
import edu.api.template.utils.ApiUtils;
import org.junit.jupiter.api.Test;

public class SampleTest extends BaseTest {

  @Test
  public void testGetMethod() {
    String jsonBody =
        """
{
  "id": 10,
  "name": "doggie",
  "category": {
    "id": 1,
    "name": "Dogs"
  },
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}""";

    given(ApiUtils.getBaseRequestSpec())
        .baseUri(ConfigManager.getInstance().getBaseUrl())
        .body(jsonBody)
        .when()
        .post()
        .then()
        .statusCode(200);
  }
}
