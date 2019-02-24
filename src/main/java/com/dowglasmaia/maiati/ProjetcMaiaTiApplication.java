package com.dowglasmaia.maiati;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**@author Dowglas Maia
 * Skype: live:dowglasmaia
 * E-mail:dowglasmaia@live.com
 * */

@SpringBootApplication
public class ProjetcMaiaTiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetcMaiaTiApplication.class, args);
		
		//gerarSenha();
	}

	
	
	
	//private static void gerarSenha() {
		//System.out.println(new BCryptPasswordEncoder().encode("abc"));
	//}

}
