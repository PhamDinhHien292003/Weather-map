package com.example.demo.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class Filter {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/check-weather/login", "/public/**").permitAll()  // Public endpoints
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login.loginPage("/check-weather/login").permitAll()
                )
                .csrf(csrf -> csrf.ignoringRequestMatchers("/public/**")); // Configure as necessary

        return http.build();
    }
}
