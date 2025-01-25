package com.frobledo.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider {
	
	@Value("${jwt.secret}") private String secretKey;
	@Value("${jwt.expiration}") private long validityInMilliseconds;
	
	// Generación del token
	public String createToken(Authentication authentication) { 
		String username = authentication.getName();
		Date now = new Date(); 
		Date expiryDate = new Date(now.getTime() + validityInMilliseconds);
		
		return Jwts.builder() 
				.setSubject(username) 
				.setIssuedAt(now)
				.setExpiration(expiryDate) 
				.signWith(SignatureAlgorithm.HS512, secretKey) 
				.compact(); 
	}
	
	// Validación del token 
	public boolean validateToken(String token) { 
		try { Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token); 
		return true; 
		} catch (JwtException | IllegalArgumentException e) { 
			throw new RuntimeException("Invalid JWT token");
		}
	}
	
	// Obtener el nombre de usuario del token 
	public String getUsernameFromToken(String token) { 
		return Jwts.parser().setSigningKey(secretKey) 
				.parseClaimsJws(token).getBody().getSubject(); 
	}
	
	// Obtener los claims del token
	public Claims getClaimsFromToken(String token) { 
		try { 
			return Jwts.parser() 
					.setSigningKey(secretKey) 
					.parseClaimsJws(token) 
					.getBody(); 
			} catch (JwtException e) {
				throw new RuntimeException("Invalid JWT token"); 
			} 
	}

}
