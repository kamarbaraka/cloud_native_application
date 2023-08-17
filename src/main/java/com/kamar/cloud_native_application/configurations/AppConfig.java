package com.kamar.cloud_native_application.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * configuration class for the application.
 * @author kamar baraka.
*/

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.kamar.cloud_native_application.components")
public class AppConfig {
}
