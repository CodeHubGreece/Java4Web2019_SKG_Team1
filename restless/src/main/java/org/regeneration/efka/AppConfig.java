package org.regeneration.efka;

import org.regeneration.efka.security.ApiAccessDeniedHandler;
import org.regeneration.efka.security.ApiAuthenticationEntryPoint;
import org.regeneration.efka.security.ApiAuthenticationSuccessHandler;
import org.regeneration.efka.security.ApiUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

    private ApiAuthenticationEntryPoint authenticationEntryPoint;
    private ApiAuthenticationSuccessHandler apiSuccessHandler;
    private ApiAccessDeniedHandler accessDeniedHandler;
    private ApiUserDetailService userDetailService;

    @Autowired
    public void setAuthenticationEntryPoint(ApiAuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    @Autowired
    public void setApiSuccessHandler(ApiAuthenticationSuccessHandler apiSuccessHandler) {
        this.apiSuccessHandler = apiSuccessHandler;
    }

    @Autowired
    public void setAccessDeniedHandler(ApiAccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Autowired
    public void setUserDetailsService(ApiUserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/citizen/register").permitAll()
                .antMatchers("doctor/**").hasRole("d")
                .antMatchers("citizen/**").hasRole("c")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(apiSuccessHandler)
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login.html");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

