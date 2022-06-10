package br.com.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.forum.domain.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		Date dataAtual = new Date();
		
		Date timeExpiration = new Date(dataAtual.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API Fórum")
				.setSubject(usuario.getId().toString())
				.setIssuedAt(dataAtual)
				.setExpiration(timeExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
