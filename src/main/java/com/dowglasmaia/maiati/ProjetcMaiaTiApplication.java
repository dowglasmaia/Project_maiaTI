package com.dowglasmaia.maiati;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dowglasmaia.maiati.domain.Cargo;
import com.dowglasmaia.maiati.domain.Cidade;
import com.dowglasmaia.maiati.domain.Departamento;
import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.domain.Funcionario;
import com.dowglasmaia.maiati.repository.domain.CargoRepository;
import com.dowglasmaia.maiati.repository.domain.CidadeRepository;
import com.dowglasmaia.maiati.repository.domain.DepartamentoRepository;
import com.dowglasmaia.maiati.repository.domain.EstadoRepository;
import com.dowglasmaia.maiati.repository.domain.FuncionarioRepository;

/**
 * @author Dowglas Maia Skype: live:dowglasmaia E-mail:dowglasmaia@live.com
 */

@SpringBootApplication
public class ProjetcMaiaTiApplication implements CommandLineRunner {

	@Autowired
	private DepartamentoRepository depRepo;

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private CidadeRepository cidRepo;

	@Autowired
	private EstadoRepository estrepo;

	@Autowired
	private FuncionarioRepository funRepo;

	public static void main(String[] args) {
		SpringApplication.run(ProjetcMaiaTiApplication.class, args);

		// gerarSenha();
	}

	@Override
	public void run(String... args) throws Exception {

		Departamento d1 = new Departamento();		
		d1.setNome("Vendas");
		d1.setCargos(null);

		depRepo.save(d1);
		
		Cargo cg = new Cargo(null, "TR0", d1);
		cargoRepository.save(cg);
		
		Cidade cd = new Cidade(null, "City 1");
		cidRepo.save(cd);
		
		Estado uf = new Estado(null, "TT", "Est Test1");
		estrepo.save(uf);
	
		
		
		
		


	}

	// private static void gerarSenha() {
	// System.out.println(new BCryptPasswordEncoder().encode("abc"));
	// }

}
