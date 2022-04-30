package com.project.operation.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CustomErrorResponse {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
    }
