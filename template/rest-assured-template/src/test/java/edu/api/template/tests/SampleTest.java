package edu.api.template.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import edu.api.template.base.BaseTest;
import edu.api.template.model.DummyObject;
import edu.api.template.utils.ApiUtils;
import org.junit.jupiter.api.Test;

public class SampleTest extends BaseTest {

  @Test
  public void testGetMethod() {
    given()
        .spec(ApiUtils.getBaseRequestSpec())
        .basePath("/todos/1")
        .when()
        .get()
        .then()
        .statusCode(200)
        .body("id", equalTo(1));

    // alternative option
    //    assertThat(response.statusCode()).isEqualTo(200);
    //    DummyObject dummyObject = response.body().as(DummyObject.class);
    //    assertThat(dummyObject.getId()).isEqualTo(1);
  }

  @Test
  public void testPostMethod() {
    given()
        .spec(ApiUtils.getBaseRequestSpec())
        .body(new DummyObject(2, 2, "DummyTitle", false))
        .basePath("/posts")
        .when()
        .post()
        .then()
        .statusCode(201)
        .body("id", equalTo(101));
  }
}
