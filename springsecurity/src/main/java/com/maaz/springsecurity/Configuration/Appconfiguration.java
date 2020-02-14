package com.maaz.springsecurity.Configuration;

import javax.servlet.annotation.HttpConstraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class Appconfiguration extends WebSecurityConfiguration {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        String passwordmike = passwordencoder().encode("password");
        String passwordjohn = passwordencoder().encode("password2");
        auth.inMemoryAuthentication().withUser("mike").password(passwordmike).roles("Developer").and().withUser("john")
                .password(passwordjohn).roles("Consultant");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/nosecurity/**").permitAll().antMatchers("/developer/**")
                .hasRole("Developer").antMatchers("/consultant/**").hasRole("Consultant").and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordencoder() {
        return new BCryptPasswordEncoder();
    }
}
