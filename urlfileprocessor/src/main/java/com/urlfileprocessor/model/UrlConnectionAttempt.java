package com.urlfileprocessor.model;

public class UrlConnectionAttempt {
  private String url;
  private String error;

  public UrlConnectionAttempt(String url, String error) {
    this.url = url;
    this.error = error;
  }

  public String getUrl() {
    return url;
  }

  public String getError() {
    return error;
  }
}
