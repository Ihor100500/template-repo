package edu.api.template.utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiUtils {

  public static RequestSpecification getRequest() {
    return given()
        .header("Content-Type", "application/json")
        .relaxedHTTPSValidation();
  }

  public static RequestSpecification postRequest(Object payload) {
    return given()
        .header("Content-Type", "application/json")
        .body(payload)
        .relaxedHTTPSValidation();
  }
}
