package com.crazyvaperV2.config.security;

import com.crazyvaperV2.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/resources/**", "/atomizer/**", "/ecig/**"
                        , "/eliquid/**", "/mod/**", "/buyProduct", "/cart/**").permitAll()
                .antMatchers().access("hasRole('USER') and hasRole('ADMIN')")
                .antMatchers("/**").access("hasRole('ADMIN')")
                .and().formLogin()
                .loginPage("/loginAndRegistration").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .and().exceptionHandling().accessDeniedPage("/error_page");
    }
}
