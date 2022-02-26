package com.example.springsecurity.service.impl;

import com.example.springsecurity.service.MyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Component
public class MyServiceImpl implements MyService {

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 获取登录实体
        Object obj = authentication.getPrincipal();
        // 判断登录实体是否实现UserDetails
        if (obj instanceof UserDetails){
            UserDetails userDetails = (UserDetails) obj;
            // 获取登录实体拥有的权限
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            // 返回登录实体拥有的权限中是否包含想要访问的url
            return authorities.contains(new SimpleGrantedAuthority(request.getRequestURI()));
        }
        return false;
    }
}
