package com.example.springsecurity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.springsecurity.domain.LoginUser;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /**
         * 根据用户名查询用户信息
         * LambdaQueryWrapper 是 mybatis plus 中实现查询的对象封装操作类，只是是需要使用 Lambda 语法使用 Wrapper
         * ::在java8中的作用就是获得方法
         */
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(wrapper);
        // 如果查询不到数据就通过抛出异常来给出提示
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或密码错误");
        }

        /**
         * 查询出的密码，注册时已经加密过的不处理，未加密的直接把密码放入构造方法中加密
         */
        // 注册时未加密需要对密码进行加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 注册时已经加密的无需处理，1234 经 BCryptPasswordEncoder 加密后为 $2a$10$LRuPoa5J3hZVYp.wuI7NpeodRcENiFzuXgUdiWKzccxs4OqOiGxHC


        // TODO 根据用户查询权限信息 添加到 LoginUser 中
        // 封装成 UserDetails 对象返回
        return new LoginUser(user);
    }
}
