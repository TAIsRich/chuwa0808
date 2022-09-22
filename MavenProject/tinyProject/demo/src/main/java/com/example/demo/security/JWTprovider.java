package com.example.demo.security;

import com.example.demo.exception.BlogAPIException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.Date;

@Component
public class JWTprovider {
    @Value("${app.jwt-secrete}")
    private String jwt_secrete;

    @Value("${app.jwt-expiration-milliseconds")
    private int jwtExpirationInMs;

    public String generateJWTtoken(Authentication auth){
        String name = auth.getName();
        Date curDate = new Date();
        Date expireDate = new Date(curDate.getTime()+jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(name)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, jwt_secrete)
                .compact();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwt_secrete).parseClaimsJws(token);
            return true;
        }catch (SignatureException ex){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "JWT claims string is empty.");
        }
    }
    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwt_secrete)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
