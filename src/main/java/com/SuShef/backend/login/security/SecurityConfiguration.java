package com.SuShef.backend.login.security;


import com.SuShef.backend.middlewares.JwtAuthenticationFilter;
import com.SuShef.backend.middlewares.UserScopeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final UserScopeFilter userScopeFilter;

    public SecurityConfiguration(JwtAuthenticationFilter jwtAuthFilter, UserScopeFilter userScopeFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userScopeFilter = userScopeFilter;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/register", "/user/login").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                // Add JWT filter first
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                // Add DB Scope filter AFTER the JWT filter
                .addFilterAfter(userScopeFilter, JwtAuthenticationFilter.class);

        return http.build();


    }
}
