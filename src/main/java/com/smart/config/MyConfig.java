package com.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MyConfig extends WebSecurityConfiguration {


    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .authorizeRequests()
             .requestMatchers("/login").permitAll()
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .defaultSuccessUrl("/dashboard", true) // Redirect to /dashboard after successful login
             .permitAll()
             .and()
         .logout()
             .permitAll();
 }

 @Bean
 public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }
}

