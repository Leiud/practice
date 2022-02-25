package com.example.springsecurity.filter;

import com.example.springsecurity.domain.LoginUser;
import com.example.springsecurity.utils.JwtUtil;
import com.example.springsecurity.utils.RedisCacheUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头中的token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            // 请求头中没有token，访问接口相当于没有登录，直接放行，让其登录
            filterChain.doFilter(request, response);
            return;
        }
        // 解析token，获取uuid
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid = claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        // 从redis中获取用户信息
        String redisKey = "login:" + userid;
        LoginUser loginUser = redisCacheUtil.getCacheObject(redisKey);
        if(Objects.isNull(loginUser)){
            // redis中没有用户信息，即用户没有登录过
            throw new RuntimeException("用户未登录");
        }
        // 存入 SecurityContextHolder
        // TODO 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }
}
