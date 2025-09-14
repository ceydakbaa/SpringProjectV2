package com.example.ceyda.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class jwtService {

    @Value("${spring.security.jwt.secret-key}")    //application.yaml'dan secret key'i çekmek için bunu oluşturuyoruz.
    private String SECRET_KEY;

    //İlk önce bir token oluşturuyoruz.
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60*24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    //Oluşturduğum tokenları parçalara ayırıyorum.
    public <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        Claims claims=Jwts
                .parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token).getBody();
        return claimsTFunction.apply(claims);
    }

    public String getUsernameByToken(String token) {     //Tokendan username'i almam lazım.
        return extractClaims(token, Claims::getSubject);
    }

    public boolean validateToken(String token) {
        String username = getUsernameByToken(token);
        return username != null && isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        Date expiredDate= extractClaims(token, Claims::getExpiration);
        return expiredDate.before(new Date());
    }
    public Key getSigninKey() {
        byte[] keyByte= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyByte);
    }

}
