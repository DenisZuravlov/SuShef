package com.SuShef.backend.login.service;


import com.SuShef.backend.middlewares.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@Service
@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    // Extract the User ID (stored as a custom claim or 'subject')
    public Long extractUserId(String token) {
        String userIdString = extractClaim(token, Claims::getSubject);
        return Long.parseLong(userIdString);
    }

    // Extract the Email/Username
    public String extractEmail(String token) {
        return extractClaim(token, claims -> claims.get("email", String.class));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser() // Use parser() instead of parserBuilder()
                .verifyWith((SecretKey) getSignInKey()) // Use verifyWith instead of setSigningKey
                .build()
                .parseSignedClaims(token) // Use parseSignedClaims instead of parseClaimsJws
                .getPayload(); // Use getPayload() instead of getBody()
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserPrincipal userPrincipal) {
        return generateToken(new HashMap<>(), userPrincipal);
    }

    public String generateToken(Map<String, Object> extraClaims, UserPrincipal userPrincipal) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                // We set the Subject as the UserId so extractUserId() can find it easily
                .setSubject(userPrincipal.getId().toString())
                // Optional: add email as a custom claim
                .claim("email", userPrincipal.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // Set expiration (e.g., 24 hours)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

}
