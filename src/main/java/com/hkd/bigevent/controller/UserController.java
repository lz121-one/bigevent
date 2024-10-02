package com.hkd.bigevent.controller;

import com.hkd.bigevent.pojo.Result;
import com.hkd.bigevent.pojo.User;
import com.hkd.bigevent.service.UserService;
import com.hkd.bigevent.util.JwtUtil;
import com.hkd.bigevent.util.Md5Util;
import com.hkd.bigevent.util.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}") String username,@Pattern(regexp = "^\\S{5,16}") String password){
        //查询用户
        User u = userService.findUserByName(username);
        if(u == null){
            //用户还未注册
            //注册用户
            //加密
            String md5String = Md5Util.getMD5String(password);
            userService.register(username,md5String);
            return Result.success();
        }else{
            //用户已经被注册
            return Result.error("用户已经被注册");
        }

    }
    //登录
    @PostMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,16}") String username,@Pattern(regexp = "^\\S{5,16}") String password){
        User u = userService.findUserByName(username);
        if(u != null){
            if(u.getPassword().equals(Md5Util.getMD5String(password))){
                //登录成功
                Map<String,Object> claims = new HashMap<>();
                claims.put("id",u.getId());
                claims.put("username",u.getUsername());
                String token = JwtUtil.getToken(claims);
                return Result.success(token);
            }else{
                return Result.error("密码错误");
            }
        }else{
            return Result.error("账号或密码错误");
        }
    }
    //获取用户详细信息
    @GetMapping("/userInfo")
    public Result UserInfo(){
        System.out.println("年后");
        Map<String,Object> claims = ThreadLocalUtil.get();
        System.out.println(claims);
        String username = (String) claims.get("username");
        User u = userService.findUserByName(username);
        return Result.success(u);
    }
}
