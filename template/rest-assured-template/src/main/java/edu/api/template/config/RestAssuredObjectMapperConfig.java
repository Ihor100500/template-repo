package edu.api.template.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.mapper.ObjectMapperType;

public class RestAssuredObjectMapperConfig {
  private RestAssuredObjectMapperConfig(){}

  public static RestAssuredConfig configRestAssuredObjectMapper(){
    ObjectMapper customObjectMapper = ObjectMapperProvider.createObjectMapper();
    return RestAssured.config().objectMapperConfig(RestAssured.config().getObjectMapperConfig()
        .defaultObjectMapperType(ObjectMapperType.JACKSON_2)
        .jackson2ObjectMapperFactory(((type, s) -> customObjectMapper)));
  }
}
