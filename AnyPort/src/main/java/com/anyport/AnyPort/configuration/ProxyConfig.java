package com.anyport.AnyPort.configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ProxyConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("**")
                .allowedOrigins("*") // Replace with your Netlify app's URL
                .allowedMethods("*")
                .allowedHeaders("*")

                .allowCredentials(true);

    }


}
