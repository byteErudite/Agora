package com.vaibhav.Agora.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.vaibhav.Agora.Common.Constants.Constants.ADD;
import static com.vaibhav.Agora.Common.Constants.Constants.ALL;
import static com.vaibhav.Agora.Common.Constants.Constants.BOOK;
import static com.vaibhav.Agora.Common.Constants.Constants.FORWARD_SLASH;
import static com.vaibhav.Agora.Common.Constants.EndPoints.ADD_BOOK;
import static com.vaibhav.Agora.Common.Constants.EndPoints.GET_ALL_BOOKS;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("vaibhav")
//                .password("password")
//                .roles("ADMIN")
//                .and().withUser("batman").password("alfred").roles("USER");
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest()
                .authenticated()
                .and().httpBasic();
//        http.csrf().disable().authorizeRequests()
//                .antMatchers(GET_ALL_BOOKS).hasAnyRole("USER","ADMIN")
//                 .antMatchers(ADD_BOOK).hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and().formLogin();
    }
}
