package com.example.springsecurity.config;

import com.example.springsecurity.handler.MyAccessDeniedHandler;
import com.example.springsecurity.handler.MyAuthenticationSuccessHandler;
import com.example.springsecurity.handler.MyForwardAuthenticationFailureHandler;
import com.example.springsecurity.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successForwardUrl("/toIndex")
                //.successHandler(new MyAuthenticationSuccessHandler("/index.html"))
                .failureHandler(new MyForwardAuthenticationFailureHandler("/error.html"));

        http.authorizeRequests()
                // .antMatchers("/index.html").permitAll()
                // .antMatchers("/index.html").access("permitAll")
                .antMatchers("/login.html").permitAll()
                // .antMatchers("/error.html").permitAll()
                // .antMatchers("/error.html").access("hasRole('abc')")
                // .antMatchers("/js/**").hasRole("jsAdmin")
                .anyRequest().authenticated();
                //.anyRequest().access("@myServiceImpl.hasPermission(request,authentication)");

        // 设置异常处理器
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);

        http.rememberMe()
                // 失效时间，单位秒
                .tokenValiditySeconds(120)
                // 登录逻辑交给哪个对象
                .userDetailsService(userService)
                // 持久层对象
                .tokenRepository(persistentTokenRepository);

        // 关闭csrf防护
        http.csrf().disable();
    }


}
