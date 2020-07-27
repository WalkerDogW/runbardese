package com.runbardese.common.utils.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.Map;

@ConfigurationProperties("jwt.config")
public class JwtUtils {
    //签名私钥
    private String key;

    //签名的实效时间
    private Long ttl;

    public JwtUtils() {
    }

    public JwtUtils(String key, Long ttl) {
        this.key = key;
        this.ttl = ttl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getTtl() {
        return ttl;
    }

    public void setTtl(Long ttl) {
        this.ttl = ttl;
    }

    /**
     * 设置认证token
     *      id：登录用户id
     *      subject: 登录用户名
     */
    public String createJwt(String id, String name, Map<String,Object> map){
        //设置失效时间
        long now = System.currentTimeMillis();//当前毫秒
        long exp = now + ttl;
        //创建jwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name)
                                .setIssuedAt(new Date())
                                .signWith(SignatureAlgorithm.HS256,key);
        //根据map设置claims
        for(Map.Entry<String,Object> entry : map.entrySet()){
            jwtBuilder.claim(entry.getKey(),entry.getValue());
        }
        jwtBuilder.setExpiration(new Date(exp));
        //创建token
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 解析token字符串获取clamis
     */
    public Claims parseJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }


}
