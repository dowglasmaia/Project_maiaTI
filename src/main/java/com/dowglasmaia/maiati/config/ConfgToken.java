package com.dowglasmaia.maiati.config;

import java.util.Date;

import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Class Responsavel por Gerar e Verificar se o tem e Valido
 * 
 */

@Configuration
public class ConfgToken {

	private static String CHAVE = "maia-chave-token";

	// gerar Token - Algoritimmo para geração neste caso é o HS512 - https://jwt.io/
	public static String gerarToken(String subject) {
		String token = Jwts.builder().setSubject(subject)
				.setExpiration(new Date(System.currentTimeMillis() + (10 * 60000)))
				.signWith(SignatureAlgorithm.HS512, CHAVE).compact();
		return token;
	}

	/* Verificando Token */
	public static String verivicaToken(String token) throws Exception {
		if (token != null) {
			try {
				return Jwts.parser().setSigningKey(CHAVE).parseClaimsJws(token).getBody().getSubject();

			} catch (Exception e) {
				throw new Exception("Token inválido ou expirado");
			}
		}
		throw new Exception("Necessário informar o token!");
	}

}
