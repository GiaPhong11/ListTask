package com.example.list_task.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {
	//1 interface nằm trong Spring Security

	private final UserDetailsService userDetailsService;

	public SecurityConf(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()


				.antMatchers("/admin/**").authenticated()/*hasAuthority("ADMIN")*/
				/*.antMatchers("/user/home").hasRole("GUEST")*/
				.and()

				// Cấu hình trang đăng nhập
				.formLogin().loginPage("/login").loginProcessingUrl("/perform_login").

				defaultSuccessUrl("/admin/pageTask", true)
				.failureUrl("/login?login_error=true")
				.permitAll() //

				.and()

				//Cấu hình trang logout
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true)
				.deleteCookies("JSESSIONID").permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder(4));//mã hóa
	}

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder(4).encode("admin2"));
	}
}
