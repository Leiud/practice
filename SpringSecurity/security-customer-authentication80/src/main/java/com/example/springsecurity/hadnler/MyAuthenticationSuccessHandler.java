package com.example.springsecurity.hadnler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MyAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Principal 主体，存放了登录用户的信息
        User user = (User) authentication.getPrincipal();
        // 用户名
        System.out.println(user.getUsername());
        // 密码，输出 null
        System.out.println(user.getPassword());
        // 权限
        System.out.println(user.getAuthorities());
        response.sendRedirect(url);
    }
}
