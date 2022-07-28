package com.example.giaphong.Conf;

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

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()

				// Cho phép các request static không bị ràng buộc
				.antMatchers("/user/**", "/manager/**", "/upload/**").permitAll()

				// Các request kiểu "/admin/" phải đăng nhập
				/*.antMatchers("/admin/**").hasAuthority("ADMIN")
				.antMatchers("/user/home").hasRole("GUEST")*/
				.and()

				// Cấu hình trang đăng nhập
				.formLogin().loginPage("/login").loginProcessingUrl("/perform_login").

				defaultSuccessUrl("/index", true)
				.failureUrl("/login?login_error=true")
				.permitAll()//

				.and()

				//Cấu hình trang logout
				.logout().logoutUrl("/logout").logoutSuccessUrl("/index").invalidateHttpSession(true)
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
