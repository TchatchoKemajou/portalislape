/*package com.empereur.security.Security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class Websecurity extends WebSecurityConfigurerAdapter{
 
@Override 
protected void configure(HttpSecurity http) throws Exception{
    http.cors().and().csrf().disable().authorizeRequests().antMatchers("/users").hasRole("managers").anyRequest().authenticated().and().formLogin();
} 
}*/
