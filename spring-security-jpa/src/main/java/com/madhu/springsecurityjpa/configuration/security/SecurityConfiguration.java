package com.madhu.springsecurityjpa.configuration.security;

import com.madhu.springsecurityjpa.common.SecurtyConstants;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(SecurtyConstants.URI_ADMIN).hasRole(SecurtyConstants.ROLE_ADMIN)
                .antMatchers("/getUserByName").hasRole(SecurtyConstants.ROLE_ADMIN)
                .antMatchers(SecurtyConstants.URI_USER)
                .hasAnyRole(SecurtyConstants.ROLE_ADMIN, SecurtyConstants.ROLE_USER)
                .antMatchers(SecurtyConstants.URI_ROOT).permitAll().anyRequest().fullyAuthenticated()
                .and().formLogin();
    }

    public SecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
