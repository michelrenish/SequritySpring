package com.jsp.SecurityPro.seviceImpli;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.jsp.SecurityPro.sevice.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImp implements JwtService {

	private final String sec = "bgGd720CeHP4kY9mGuMEoteBq4TP4d0W2XkpiI4bVgg";

	@Override
	public String generateTocken(String username) {
		Map<String, Object> clamis = new HashMap<String, Object>();
		return createToken(clamis, username);
	}
	/*
	 * jjwt jakson jjwt api jjwt impln
	 */

	private String createToken(Map<String, Object> clamis, String username) {
		return Jwts.builder().setClaims(clamis).setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 300000))
				.signWith(generatedKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key generatedKey() {
		byte[] key = Decoders.BASE64.decode(sec);
//		System.out.println(key);
		return Keys.hmacShaKeyFor(key);
	}

	@Override
	public String extractUsername(String token) {
		return extractClamis(token, Claims::getSubject);
	}
	private <T> T extractClamis(String token,Function<Claims,T>claimsResolver) {
		Claims claims =extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(generatedKey()).build().parseClaimsJws(token).getBody();
	}
	private Date extractExpiration(String token) {
		return extractClamis(token, Claims::getExpiration);
	}

	@Override
	public boolean validate(String token, UserDetails u1) {
		String username = extractUsername(token);
		return username.equals(u1.getUsername()) && isTokenAlive(token);
	}
	private boolean isTokenAlive(String token) {
		return new Date().before(extractExpiration(token));
	}
}
