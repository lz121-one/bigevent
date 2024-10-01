package com.hkd.bigevent.interceptors;

import com.hkd.bigevent.pojo.Result;
import com.hkd.bigevent.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取令牌
        String token = request.getHeader("Authorization");
        //令牌验证
        try{
            Map<String, Object> calims = JwtUtil.parseToken(token);
            //验证成功，放行
            return true;
        }catch(Exception e){
            //验证失败，不放行
            response.setStatus(401);
            return false;
        }
    }
}
