package com.example.angular_java_practice.fsd;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")  // Allow CORS for all endpoints starting with /api/
               .allowedOrigins("http://localhost:4200")  // Allow Angular app
               .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific HTTP methods
               .allowedHeaders("*")  // Allow all headers
               .allowCredentials(true);  // Allow credentials (cookies, authentication headers)
    }
}

