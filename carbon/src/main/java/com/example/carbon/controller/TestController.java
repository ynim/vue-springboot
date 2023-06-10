package com.example.carbon.controller;

import com.example.carbon.domain.User;
import com.example.carbon.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private StringRedisTemplate template;

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/hello")
    public String hello(){
        template.opsForValue().set("11","hello",2, TimeUnit.MINUTES);
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        String v=template.opsForValue().get("11");
        return template.opsForValue().get("11");
    }

    @RequestMapping("/test")
    public String test(){
        User user=new User();
        user.setUsername("admin");
        user.setPassword("$2a$10$dWL24wjqpNroS1GmcjjRsO.OFJfyWfyQlttpc/EKX3hGXFsM/Eoh6");
       userMapper.addUser(user);
        return "su";
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("admin123"));

    }
}
