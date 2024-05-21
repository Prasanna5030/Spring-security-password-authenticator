
package com.sl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.sl.config.service.UserInfoUserDetailService;

@Configuration

@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		/*
		 * UserDetails admin =
		 * User.withUsername("prasanna").password(encoder.encode("pk@123")).roles(
		 * "ADMIN").build();
		 * 
		 * UserDetails user =
		 * User.withUsername("lazy").password(encoder.encode("coder")).roles("ADMIN").
		 * build();
		 * 
		 * return new InMemoryUserDetailsManager(admin, user);
		 */

		return new UserInfoUserDetailService();
	}

	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception { return http.csrf(AbstractHttpConfigurer::disable)
	 * .authorizeHttpRequests(auth -> auth.requestMatchers("/api/products/welcome",
	 * "/api/user/add")
	 * .permitAll().requestMatchers("/api/product/**").authenticated())
	 * .httpBasic(Customizer.withDefaults()).build(); }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
}
