package edu.api.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DummyObject {

  @JsonProperty("userId")
  private int userId;

  @JsonProperty("id")
  private int id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("completed")
  private boolean completed;
}
