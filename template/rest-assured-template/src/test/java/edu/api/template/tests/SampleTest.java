package edu.api.template.tests;

import static org.assertj.core.api.Assertions.assertThat;

import edu.api.template.utils.ApiUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SampleTest {

  @Test
  public void test() {

    Response response = ApiUtils.getRequest().basePath("/path/").when().get();

    assertThat(response.statusCode()).isEqualTo(404);
  }
}
