package com.dev.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebserviceApplication.class, args);
	}
//	@Configuration
//	@EnableGlobalMethodSecurity(prePostEnabled = true)
//	@EnableWebSecurity
//	static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//		/**
//		 * This section defines the user accounts which can be used for authentication as well as the roles each user has.
//		 * 
//		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
//		 */
//		@Override
//		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//			auth.inMemoryAuthentication().//
//					withUser("admin").password("123").roles("ADMIN");//
//		}
//
//		/**
//		 * This section defines the security policy for the app.
//		 * <p>
//		 * <ul>
//		 * <li>BASIC authentication is supported (enough for this REST-based demo).</li>
//		 * <li>/employees is secured using URL security shown below.</li>
//		 * <li>CSRF headers are disabled since we are only testing the REST interface, not a web one.</li>
//		 * </ul>
//		 * NOTE: GET is not shown which defaults to permitted.
//		 *
//		 * @param http
//		 * @throws Exception
//		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
//		 */
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//
//			http.httpBasic().and().authorizeRequests().//
//					antMatchers(HttpMethod.POST, "/employees").hasRole("ADMIN").//
//					antMatchers(HttpMethod.PUT, "/employees/**").hasRole("ADMIN").//
//					antMatchers(HttpMethod.PATCH, "/employees/**").hasRole("ADMIN").and().//
//					csrf().disable();
//		}
//	}
}
