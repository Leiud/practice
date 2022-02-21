package com.example.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class BCryptPasswordEncoderTest {

    @Test
    public void test(){
        // 创建解析器
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 对密码加密
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);

        // 判断原字符和加密后内容是否匹配
        System.out.println("123:::123："+passwordEncoder.matches("123", encode));
        System.out.println("123:::1234："+passwordEncoder.matches("1234", encode));
    }
}
