package com.dowglasmaia.maiati.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	// metodo que informa quais url estão liberas para fazer requisições POST,PUT e
	// DELETE
	private static final String[] PUBLIC_MATCHERS = { "/**"

	};

	// metodo que informa quais url estão liberas para fazer requisições GET
	private static final String[] PUBLIC_MATCHERS_GET = { "/**"

	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* liberando o acesso para o h2-console */
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}

		http.cors().and().csrf().disable();
		http.authorizeRequests().antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
				.antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 

	}

	/* Configuração do Cors da Aplicação - Para acesso a Multiplas Fontes */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;

	}
	
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer dateCustomizer() {
		return new  Jackson2ObjectMapperBuilderCustomizer() {

			@Override
			public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
				jacksonObjectMapperBuilder.simpleDateFormat("yyyy-MM-dd");
				
			}
			
		};
	}
	

}
