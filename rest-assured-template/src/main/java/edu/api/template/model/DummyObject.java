package edu.api.template.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
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
