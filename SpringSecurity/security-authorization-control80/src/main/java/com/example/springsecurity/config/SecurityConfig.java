package com.example.springsecurity.config;

import com.example.springsecurity.handler.MyAuthenticationSuccessHandler;
import com.example.springsecurity.handler.MyForwardAuthenticationFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successHandler(new MyAuthenticationSuccessHandler("/index.html"))
                .failureHandler(new MyForwardAuthenticationFailureHandler("/error.html"));

        http.authorizeRequests()
                // .antMatchers("/index.html").permitAll()
                // .antMatchers("/index.html").hasAuthority("admin")
                // .antMatchers("/index.html").hasAnyAuthority("adMin","admiN")
                //.antMatchers("/index.html").hasRole("abc")
                .antMatchers("/index.html").hasIpAddress("192.168.1.130")
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                // 放行js和css文件夹下所有文件
                // .antMatchers("/js/**","/css/**").permitAll()
                // 放行.js文件
                // .antMatchers("/**/*.js").permitAll()
                // 只允许post请求访问.js文件
                .regexMatchers( HttpMethod.POST, ".+[.]js").permitAll()
                .anyRequest().authenticated();

        // 关闭csrf防护
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
