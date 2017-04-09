package com.elys.jwt.config;

import com.elys.jwt.security.CustomAuthenticationEntryPoint;
import com.elys.jwt.security.CustomAuthenticationFilter;
import com.elys.jwt.security.CustomAuthenticationProvider;
import com.elys.jwt.security.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Elys Javier Rivero
 *
 * @since 09/04/17
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider authenticationProvider;
    private final CustomAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    public WebSecurityConfig(CustomAuthenticationProvider authenticationProvider, CustomAuthenticationEntryPoint unauthorizedHandler) {
        this.authenticationProvider = authenticationProvider;
        this.unauthorizedHandler = unauthorizedHandler;
    }

    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter authenticationTokenFilter = new CustomAuthenticationFilter();
        authenticationTokenFilter.setAuthenticationManager(authenticationManager());
        authenticationTokenFilter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
        return authenticationTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf().disable()
                // All urls must be authenticated (filter for token always fires (/**)
                .authorizeRequests().anyRequest().authenticated()
                .and()
                // Call our errorHandler if authentication/authorisation fails
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //.and()
        // Custom JWT based security filter

        httpSecurity.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        httpSecurity.headers().cacheControl();
    }
}
