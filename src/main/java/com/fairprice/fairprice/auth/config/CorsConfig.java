package com.fairprice.fairprice.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Apply to all routes
                .allowedOriginPatterns("https://fairprice.up.railway.app","https://*.railway.app", "https://*.ngrok-free.app", "http://*.ngrok-free.app")  // Use patterns to allow subdomains or specific domains

                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
                .allowedHeaders("Authorization", "Content-Type") // Allow specific headers
                .allowCredentials(true); // Allow cookies or credentials if needed

     }
}
