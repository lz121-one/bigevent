package com.hkd.bigevent;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtTest {
    @Test
    public void testGer(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","张三");
        String token = JWT.create()
                .withClaim("user",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*12))//设置过期时间
                .sign(Algorithm.HMAC256("hkd"));//指定算法，配置密钥
        System.out.println(token);
        System.out.println(token);
        System.out.println("我是hot-fix");
    }
    //模拟解析token
    @Test
    public void parseToken(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3Mjc1OTk5ODh9" +
                ".BD2PGPci6RQALj_NrFfCjvBYYp_GQXNlft3hByxJWbY";
        JWTVerifier hkd = JWT.require(Algorithm.HMAC256("hkd")).build();
        DecodedJWT decodedJWT = hkd.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims);

    }
}
