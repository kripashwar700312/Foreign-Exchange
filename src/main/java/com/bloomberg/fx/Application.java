package com.bloomberg.fx;

import com.bloomberg.fx.filter.StubLoggingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.bloomberg.fx"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public StubLoggingFilter stubLoggingFilter() {
        return new StubLoggingFilter();
    }
}
