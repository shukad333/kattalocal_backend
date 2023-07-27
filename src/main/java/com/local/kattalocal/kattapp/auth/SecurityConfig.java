package com.local.kattalocal.kattapp.auth;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig implements SecurityFilterChain {


  @Override
  public boolean matches(HttpServletRequest request) {
    return false;
  }

  @Override
  public List<Filter> getFilters() {
    return new ArrayList<>();
  }
}
