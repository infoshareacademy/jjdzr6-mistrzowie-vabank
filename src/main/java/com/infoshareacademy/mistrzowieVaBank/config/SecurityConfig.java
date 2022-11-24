package com.infoshareacademy.mistrzowieVaBank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String SIGN_IN_PAGE = "/sign-in";
    private static final String SIGN_IN_API = "/api/sign-in";
    private static final String DASHBOARD_PAGE = "/dashboard";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**", "/bootstrap/**", "/assets/bootstrap-solid.svg",
                        "/",
                        SIGN_IN_PAGE,
                        SIGN_IN_API).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(SIGN_IN_PAGE)
                .loginProcessingUrl(SIGN_IN_API)
                .defaultSuccessUrl(DASHBOARD_PAGE, true)
                .and()
                .logout()
                .logoutUrl("/api/sign-out")
                .logoutSuccessUrl("/welcome")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
    }
}
