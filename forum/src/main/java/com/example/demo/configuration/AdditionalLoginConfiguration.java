package com.example.demo.configuration;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : hongbo
 * @create 2021-12-14-15:53
 **/
//WebMvcConfigurerAdapter弃用了
public class AdditionalLoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        //viewControllerRegistry.addViewController("/login").setViewName("login");
    }
}
