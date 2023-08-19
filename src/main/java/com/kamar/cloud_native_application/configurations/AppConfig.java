package com.kamar.cloud_native_application.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * configuration class for the application.
 * @author kamar baraka.
*/

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "com.kamar.cloud_native_application.components")
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver(){

        /*construct and return the view resolver*/
        return new InternalResourceViewResolver("/webapp/views", ".jsp");
    }
}
