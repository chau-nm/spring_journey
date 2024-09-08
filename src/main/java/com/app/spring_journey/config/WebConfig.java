package com.app.spring_journey.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.spring_journey.interceptor.Interceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new Interceptor());
  }
}
