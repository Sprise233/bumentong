package com.github.sprise233.bumentong;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class BumentongApplicationTests {

    @Test
    public void testJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "admin");
        claims.put("password", "123456");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "sdsdweqskljfhajhsdjhajkdhuowoefjkajflhalkhsljdhla")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .compact();
        System.out.println(jwt);

        System.out.println(Jwts.parser()
                .setSigningKey("sdsdweqskljfhajhsdjhajkdhuowoefjkajflhalkhsljdhla")
                .parseClaimsJws(jwt)
                .getBody());
    }

}

