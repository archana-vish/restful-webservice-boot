package com.in28minutes.rest.webservices.restfulwebservices.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {


    protected void configure(HttpSecurity http) throws Exception {
                http
                        .csrf().disable() //disable cross site request forgery
                        .authorizeRequests() // authorize requests
                        .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // allow unauthenicated requests to options
                        .anyRequest().authenticated().and()
                //.formLogin().and()
                        .httpBasic();
    }
}
