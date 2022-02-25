package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.LoginUser;
import com.example.springsecurity.domain.ResponseResult;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.LoginServcie;
import com.example.springsecurity.utils.JwtUtil;
import com.example.springsecurity.utils.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginServcie {

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Override
    public ResponseResult login(User user) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        // 使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        // authenticate存入redis
        redisCacheUtil.setCacheObject("login:"+userId,loginUser);
        // 把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
    }

    @Override
    public ResponseResult logout() {
        // 获取SecurityContextHolder中的认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 获取登录用户
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        // 获取登录用户uuid
        Long userid = loginUser.getUser().getId();
        // 从redis中删除用户信息
        redisCacheUtil.deleteObject("login:"+userid);
        return new ResponseResult(200,"退出成功");
    }
}