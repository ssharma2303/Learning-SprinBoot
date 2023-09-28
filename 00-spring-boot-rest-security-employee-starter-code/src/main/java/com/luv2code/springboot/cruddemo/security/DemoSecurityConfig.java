package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	//add support for JDBC .. no hardcoded users
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		 return new JdbcUserDetailsManager(dataSource);
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer ->
			configurer
			.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
			.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
			.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
			.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
			.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));
			
		//USE HTTP bASIC AUTHENTICATIO
		http.httpBasic(Customizer.withDefaults());
		
		//disable Cross Site Request Forgery
		
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
		
		
	}
	/*@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails John = User.builder()
				.username("John")
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		UserDetails mary = User.builder()
				.username("Mary")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER")
				.build();
		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER","ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(John,mary,susan);
		
	}*/
}
