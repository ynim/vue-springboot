package com.example.carbon.service.impl;

import com.example.carbon.domain.User;
import com.example.carbon.mapper.UserMapper;
import com.example.carbon.pojo.LoginUser;
import com.example.carbon.service.LoginServcie;
import com.example.carbon.util.JwtUtil;
import com.example.carbon.util.ResponseResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServcieImpl implements LoginServcie {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseResult login(User user) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = null;
        authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        ObjectMapper mapper = new ObjectMapper();
        template.opsForValue().set("login:"+userId,mapper.writeValueAsString(user), 60 * 24,TimeUnit.MINUTES);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
    }

    @Override
    public ResponseResult logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loginUser = (User) authentication.getPrincipal();
        Integer userid = loginUser.getId();
        template.delete("login:"+userid);
        return new ResponseResult(200,"退出成功");
    }

    @Override
    public List<User> queryUserList() {
        return null;
    }


}
