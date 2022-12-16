package com.tech.springbatchdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping( "/**" ).allowedOrigins( "http:localhost:8081" )
                .allowedMethods( "get,post,delete,put" );
        //the default configuration of CORS
        //allow cors from all Url from all request from any origin with all method
//registry.addMapping( "/**" ).allowedOrigins( "*" ).allowedMethods( "*" ).maxAge( 3600 );



    }

}
