package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 表单提交
        http.formLogin()
                // 自定义登录页面
                .loginPage("/login.html")
                // 当发现 /login 时认为是登录，必须和表单的提交地址一样；提交表单后去执行 UserServiceImpl
                .loginProcessingUrl("/login")
                // 登录成功后跳转页面，使用 POST 请求
                .successForwardUrl("/toIndex")
                // 登录失败后跳转页面，POST 请求
                .failureForwardUrl("/toError");

        http.authorizeRequests()
                // login.html 不需要被认证，放行的路径要在禁止之前写
                .antMatchers("/login.html").permitAll()
                // 所有请求都必须被认证，必须登录后被访问
                .anyRequest().authenticated();

        // 关闭 csrf 防护
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
