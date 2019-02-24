package com.dowglasmaia.maiati.config;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 * @author Dowglas Maia 
 * 
 * Class responsavel por intercepitar as requisições, e
 * verifica se o token e valido ou não
 */

public class JWTFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// buscar o token da requisição e faz a verificação e autenticação do memso.
		try {
			String token = null;
			if (((HttpServletRequest) request).getHeader("Authorization") != null) {
				token = ((HttpServletRequest) request).getHeader("Authorization").replace("Bearer ", "");
			}

			if (token != null) {
				String login = ConfgToken.verivicaToken(token);

				Authentication authentication = new UsernamePasswordAuthenticationToken(login, null, new ArrayList<>());

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}

			chain.doFilter(request, response); 

		} catch (Exception e) {
			// caso aja o erro de autenticação
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());

			e.printStackTrace();
		}

	}

}