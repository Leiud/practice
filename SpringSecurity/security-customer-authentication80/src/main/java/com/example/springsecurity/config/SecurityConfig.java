package com.example.springsecurity.config;

import com.example.springsecurity.hadnler.MyAuthenticationSuccessHandler;
import com.example.springsecurity.hadnler.MyForwardAuthenticationFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
                // .successForwardUrl("/toIndex")
                // 和 successForwardUrl 方法不能共存，登录验证成功后前往百度
                .successHandler(new MyAuthenticationSuccessHandler("http://www.baidu.com"))
                // 登录失败后跳转页面，POST 请求
                // .failureForwardUrl("/toError")
                // 和 failureForwardUrl 方法不能共存，登录验证失败后跳转到错误页面
                .failureHandler(new MyForwardAuthenticationFailureHandler("/error.html"))
                // 修改表单提交参数用户名，默认是 username
                .usernameParameter("myusername")
                // 修改表单提交参数密码，默认是 passward
                .passwordParameter("mypassword");

        http.authorizeRequests()
                // index.html 不需要被认证，放行的路径要在禁止之前写
                .antMatchers("/index.html").permitAll()
                // login.html 不需要被认证，放行的路径要在禁止之前写
                .antMatchers("/login.html").permitAll()
                // error.html 不需要被认证，放行的路径要在禁止之前写
                .antMatchers("/error.html").permitAll()
                // 对于登录接口允许匿名访问
                .antMatchers("/user/login").anonymous()
                // 所有请求都必须被认证，必须登录后被访问
                .anyRequest().authenticated();

        // 关闭csrf防护
        http.csrf().disable()
            // 不通过Session获取SecurityContext
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
