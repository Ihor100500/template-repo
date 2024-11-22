package edu.api.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// @Builder
// @Data
public class DummyObject {

  @JsonProperty("userId")
  private int userId;

  public int getUserId() {
    return userId;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  @JsonProperty("id")
  private int id;

  @JsonProperty("title")
  private String title;
}
