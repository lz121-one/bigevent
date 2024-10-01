package com.hkd.bigevent.controller;

import com.hkd.bigevent.pojo.Result;
import com.hkd.bigevent.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result getList(@RequestHeader(name = "Authorization") String token, HttpServletResponse response){
        //验证token

        try{
            Map<String, Object> calims = JwtUtil.parseToken(token);
            return Result.success("list数据");
        }catch(Exception e){
            return Result.error("未登录");
        }

    }
}
