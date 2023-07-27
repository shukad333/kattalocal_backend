package com.local.kattalocal.kattapp.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfig {

  @Value("${auth.tokenSecret}")
  private String TOKEN_SECRET;

  public String getTOKEN_SECRET() {
    return TOKEN_SECRET;
  }

  public void setTOKEN_SECRET(String TOKEN_SECRET) {
    this.TOKEN_SECRET = TOKEN_SECRET;
  }
}
