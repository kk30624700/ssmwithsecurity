package com.boottest.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userSecurityService;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.formLogin()
        	.and()
            .authorizeRequests()
                .antMatchers("/city").hasRole("ADMIN")
                .antMatchers("/exception").hasAnyRole("ADMIN", "USER")
	            .anyRequest().authenticated()
        	.and()
	        .logout()
	        	.logoutUrl("/logout")
	        	.permitAll();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
/*		auth.inMemoryAuthentication()
		.withUser("admin").password("123").roles("ADMIN")
		.and()
		.withUser("user").password("123").roles("USER");*/
    	auth.userDetailsService(userSecurityService);
    }

}

