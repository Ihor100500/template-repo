package edu.api.template.config;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider {

  private ObjectMapperProvider(){}

  public static ObjectMapper createObjectMapper(){
    ObjectMapper customObjectMapper = new ObjectMapper();
    // custom modules here
    return customObjectMapper.findAndRegisterModules();
  }
}
