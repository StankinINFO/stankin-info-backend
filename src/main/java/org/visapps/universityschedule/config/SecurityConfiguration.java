package org.visapps.universityschedule.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.visapps.universityschedule.security.AuthEntryPoint;
import org.visapps.universityschedule.security.AuthProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthProvider authProvider;
    private final AuthEntryPoint authEntryPoint;

    @Autowired
    public SecurityConfiguration(AuthProvider authProvider, AuthEntryPoint authEntryPoint) {
        this.authProvider = authProvider;
        this.authEntryPoint = authEntryPoint;
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/**")
                .permitAll()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authEntryPoint);
    }

}
