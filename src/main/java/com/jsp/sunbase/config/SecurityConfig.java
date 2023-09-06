package com.jsp.sunbase.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;





@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService  userDetailService;
	
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		 auth.userDetailsService(userDetailService).passwordEncoder(encodePwd());
		
    }
    
    protected void configure(HttpSecurity  http) throws Exception{
    	http.csrf().disable();
    	http.authorizeRequests().requestMatchers("/rest/**").authenticated().anyRequest().permitAll().and().formLogin();
    }
	     @Bean
		 public BCryptPasswordEncoder encodePwd() {
			 return new BCryptPasswordEncoder();
		 
	 }

	 }
