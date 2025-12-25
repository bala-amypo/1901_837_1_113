// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import java.util.Date;
// import org.springframework.security.core.Authentication;

// public class JwtTokenProvider {

//     private final String secret;
//     private final long expiry;

//     public JwtTokenProvider(String secret, Long expiry) {
//         this.secret = secret;
//         this.expiry = expiry;
//     }

//     public String generateToken(Authentication auth, Long id, String email, String role) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .claim("userId", id)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expiry))
//                 .signWith(SignatureAlgorithm.HS256, secret)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String getUsernameFromToken(String token) {
//         return Jwts.parser().setSigningKey(secret)
//                 .parseClaimsJws(token).getBody().getSubject();
//     }
// }
