package com.chuwa.project.exception;

import org.springframework.http.HttpStatus;

public class customerNotFoundException extends RuntimeException{
  private String resourceName;
  private Long fieldValue;
  private String field;

  public customerNotFoundException(String resourceName, String field, Long fieldValue){
    super(String.format("%s is not found with %s : %f", resourceName, field, fieldValue));
    this.field = field;
    this.fieldValue = fieldValue;
    this.resourceName =  resourceName;
  }
  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }

  public Long getFieldValue() {
    return fieldValue;
  }

  public void setFieldValue(Long fieldValue) {
    this.fieldValue = fieldValue;
  }
}

