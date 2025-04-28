package com.cjc.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Token {
	


	

	    private String secretKey = "cjc-secret-key"; // ⚡ Secret key, keep it safe

	    // Generate token
	    public String generateToken(String username) {
	        return Jwts.builder()
	                .setSubject(username) // set username inside token
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours expiry
	                .signWith(SignatureAlgorithm.HS256, secretKey)
	                .compact();
	    }

	    // Validate and extract username
	    public String extractUsername(String token) {
	        return Jwts.parser()
	                .setSigningKey(secretKey)
	                .parseClaimsJws(token)
	                .getBody()
	                .getSubject();
	    }
	}


