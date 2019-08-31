package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

/**
          * 图片绝对地址与虚拟地址映射
          */

@Configuration
@RestController
@RequestMapping(value = "/rest", produces = "application/json;charset=utf-8")
public class WebMvcConfig extends WebMvcConfigurationSupport {

            @Override
            protected void addResourceHandlers(ResourceHandlerRegistry registry) {
                File dir = new File("fileStorage");
                //System.out.println(dir.getAbsolutePath());
                registry.addResourceHandler("/files/**")
                        .addResourceLocations("file:" + dir.getAbsolutePath() + File.separator);
                registry.addResourceHandler("/rest/files/**")
                        .addResourceLocations("file:" + dir.getAbsolutePath() + File.separator);
                super.addResourceHandlers(registry);
            }
}
