package com.tech.task.models;


import java.io.Serializable;

public class ResponseWrapper implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private String Code;
  
  private String message;
  
  private Boolean flag;
  
  private Object error;
  
  public ResponseWrapper() {}
  
  public String getCode() {
    return this.Code;
  }
  
  public void setCode(String code) {
    this.Code = code;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public Boolean getFlag() {
    return this.flag;
  }
  
  public void setFlag(Boolean flag) {
    this.flag = flag;
  }
  
  public Object getError() {
    return this.error;
  }
  
  public void setError(Object error) {
    this.error = error;
  }
  
  public ResponseWrapper(String code, String message, Object error) {
    this.Code = code;
    this.message = message;
    this.error = error;
  }
  
  public ResponseWrapper(String code, String message, Boolean flag) {
    this.Code = code;
    this.message = message;
    this.flag = flag;
  }
  
  public ResponseWrapper(String code, String message, Boolean flag, Object error) {
    this.Code = code;
    this.message = message;
    this.flag = flag;
    this.error = error;
  }
  
  public String toString() {
    return "ResponseWrapper [Code=" + this.Code + ", message=" + this.message + ", flag=" + this.flag + ", error=" + this.error + "]";
  }
}
