package com.simpletrade.alpha;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http.authorizeRequests()
				// URLs matching for access rights
				.antMatchers("/").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/home**").permitAll()
				.anyRequest().authenticated()
				.and()
				// form login
				.csrf().disable()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.failureUrl("/login?error=true")
				.defaultSuccessUrl("/")
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
				// logout
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied")
				.and().build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}
