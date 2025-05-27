package com.github.sprise233.bumentong.utils;

import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JWTUtils {

    // 密钥，请确保安全性，建议放在配置文件中读取
    @Value("${token.secret}")
    private String secret;

    private static String SECRET_KEY;

    @Value("${token.expiration}")
    private long expiration;

    private static long EXPIRATION; // 24 * 60 * 60 * 1000

    private static ThreadLocal<Integer> userId = new ThreadLocal<>();
    private static ThreadLocal<String> userName = new ThreadLocal<>();

    @PostConstruct
    private void init() {
        EXPIRATION = expiration;
        SECRET_KEY = secret;
    }

    /**
     * 生成 JWT Token
     *
     * @param subject 主题，如用户ID或用户名
     * @param claims  自定义声明（可选）
     * @return 返回生成的 JWT token 字符串
     */
    public static String generateToken(String subject, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    /**
     * 解析 JWT Token 获取声明信息
     *
     * @param token 待解析的 JWT token
     * @return 返回解析后的 Jwt 对象，包含 header、body 等信息
     */
    public static Jwt parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parse(token);
    }

    /**
     * 获取用户ID
     *
     * @param token 待解析的 JWT token
     */
    public static void parseUserByToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        userId.set(Integer.parseInt(claims.get("id").toString()));
        userName.set(claims.get("username").toString());
    }

    public static Integer getUserId() {
        return userId.get();
    }

    public static String getUserName() {
        return userName.get();
    }
}
