package com.dowglasmaia.maiati;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dowglasmaia.maiati.domain.Departamento;
import com.dowglasmaia.maiati.repository.domain.DepartamentoRepository;

/**
 * @author Dowglas Maia Skype: live:dowglasmaia E-mail:dowglasmaia@live.com
 */

@SpringBootApplication
public class ProjetcMaiaTiApplication implements CommandLineRunner {

	@Autowired
	private DepartamentoRepository depRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetcMaiaTiApplication.class, args);

		// gerarSenha();
	}

	

	@Override
	public void run(String... args) throws Exception {
/*
		Departamento d1 = new Departamento();		
		d1.setNome("Vendas");
		d1.setCargos(null);

		depRepo.save(d1);
		System.out.println(d1);
*/

	}

	// private static void gerarSenha() {
	// System.out.println(new BCryptPasswordEncoder().encode("abc"));
	// }

}
