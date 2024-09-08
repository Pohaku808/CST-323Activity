package com.jads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import com.jads.business.LoginBusinessService;

/**
 * Web security configuration class
 */
@Configuration
public class WebSecurityConfig
{

	@Autowired
	private LoginBusinessService service;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * This method handles our spring security login authentication.
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/", "/images/**", "/register", "/doRegister", "/styles/**", "/aboutus", "/help")
				.permitAll()
				.requestMatchers("/service/**")
				.authenticated()
				.anyRequest().authenticated()
				)
			.formLogin(form -> form
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/products/display", true)
				)
			.logout(lo -> lo
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/")
				)
			.httpBasic();
			return http.build();
	}
	
	/**
	 * Configure
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder);
		
	}
	
	

}
