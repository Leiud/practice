package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {

    /**
     * @Autowired 注解默认required=true，表示注入的时候 bean 必须存在，否则注入失败
     */
    @Autowired(required=false)
    private UserMapper userMapper;

    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
