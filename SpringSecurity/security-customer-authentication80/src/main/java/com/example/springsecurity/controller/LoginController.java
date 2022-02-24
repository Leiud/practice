package com.example.springsecurity.controller;

import com.example.springsecurity.domain.ResponseResult;
import com.example.springsecurity.domain.User;
import com.example.springsecurity.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

     // 该方法不执行，Security 验证成功后直接走 .successForwardUrl("/toIndex"); 方法
//     @RequestMapping("/login")
//     public String login(){
//         System.out.println("登录方法");
//         return "index.html";
//     }

    /**
     * 成功后跳转页面
     * @return
     */
    @RequestMapping("/toIndex")
    public String toMain(){
        return "redirect:/index.html";
    }

    /**
     * 失败后跳转页面
     * @return
     */
    @RequestMapping("/toError")
    public String toError(){
        return "redirect:/error.html";
    }
}
