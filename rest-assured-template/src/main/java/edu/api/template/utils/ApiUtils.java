package edu.api.template.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

  public static RequestSpecification getBaseRequestSpec() {
    return new RequestSpecBuilder()
        .setContentType(ContentType.JSON)
        .addHeader("Accept", ContentType.XML.toString())
        .setRelaxedHTTPSValidation()
        .build();
  }
}
