package com.minhnb.spring.restapi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.token-validity}")
    private long tokenExpirationSecondTime;

    public String createToken(Map<String, Object> claims, String subject) {

        byte[] secretKeyBytes = Decoders.BASE64.decode(secretKey);
        SecretKey key = Keys.hmacShaKeyFor(secretKeyBytes);
        Date issuedDate = new Date();
        Date expirationDate = generateExpirationDate(issuedDate.getTime(), tokenExpirationSecondTime);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(issuedDate)
                .setExpiration(expirationDate)
                .signWith(key);

        return builder.compact();

    }


    public Claims getClaimsFromToken(String token) {

        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();

    }

    public String getUsernameFromToken(String token) {

        return getClaimsFromToken(token).getSubject();
    }

    //validate token
    public Boolean validateToken(String token, UserDetails userDetails) {

        String username = getUsernameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private static Date generateExpirationDate(Long createTime, long expirationSecondTime) {

        return new Date(createTime + (expirationSecondTime * 1000));
    }

    //check if the token has expired
    private Boolean isTokenExpired(String token) {

        Date expiration = getClaimsFromToken(token).getExpiration();

        return expiration.before(new Date());
    }

}
