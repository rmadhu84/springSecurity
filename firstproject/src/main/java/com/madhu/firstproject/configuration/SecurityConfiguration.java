package com.madhu.firstproject.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@EnableWebSecurity
@Slf4j
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements InitializingBean{

    /**
     *
     */
    private static final String USER = "USER";
    /**
     *
     */
    private static final String ADMIN = "ADMIN";



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("madhu").password("hurricane").roles(USER).and().withUser("foo")
                .password("foo").roles(ADMIN);
    }

    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/hired","/fired").hasRole(ADMIN)
        .antMatchers("/greet","/sayHello").hasAnyRole(USER, ADMIN)
        .antMatchers("/").permitAll()
        .and().formLogin();
    }



    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("***************Security Configuation set ****************");
        
    }

}
