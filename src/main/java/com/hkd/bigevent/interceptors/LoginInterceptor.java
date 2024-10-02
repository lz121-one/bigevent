package com.hkd.bigevent.interceptors;

import com.hkd.bigevent.pojo.Result;
import com.hkd.bigevent.util.JwtUtil;
import com.hkd.bigevent.util.ThreadLocalUtil;
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
            //将获得的数据存入ThreadLocal中，以便后续调用
            ThreadLocalUtil.set(calims);
            //验证成功，放行
            return true;
        }catch(Exception e){
            //验证失败，不放行
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //移除ThreadLocal，防止内存泄露
        ThreadLocalUtil.remove();
    }
}
