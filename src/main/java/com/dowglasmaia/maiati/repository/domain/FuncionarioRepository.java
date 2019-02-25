package com.dowglasmaia.maiati.repository.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dowglasmaia.maiati.domain.Funcionario;
import com.dowglasmaia.maiati.repository.AbstractRepo;

@Repository
public class FuncionarioRepository extends AbstractRepo<Funcionario, Long> {

	/* Buscar Por Nome - JPQL */
	public List<Funcionario> findByname(String name) {
		TypedQuery<Funcionario> query = getManager().createQuery("select f from Funcionario f where f.nome like :nome",
				Funcionario.class);
		query.setParameter("nome", "%" + name + "%");
		return query.getResultList();
	}

	/* busrcar por nome, com createquery - dinamica */
	public List<Funcionario> busrcarPorNome(String nome) {
		return createDinamicQuery("select f from Funcionario f where f.nome like concat('%',?1,'%')", nome);
	}

	/* Buscar Funcionario por Cargo */
	public List<Funcionario> findByCargo(Long id) {
		return createDinamicQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}
	
	/*Buscar por Data Entre Entrada e Saida */
	public List<Funcionario>findByDateEntradaSaida(LocalDate entrada, LocalDate saida){
		String sql = new StringBuilder("select f from Funcionario f ")
					.append("where f.dataAdmissao between ?1 and ?2 ")
					.append("order by f.dataAdmissao asc")
					.toString();
		return createDinamicQuery(sql, entrada, saida);
		
		
	}
	
	 /*Buscar por Data de Entrada*/
	public List<Funcionario>findByDateEntrada(LocalDate entrada){
		String sql = new StringBuilder("select f from Funcionario f ")
				.append("where f.dataAdmissao = ?1 ")
				.append("order by f.dataAdmissao asc")
				.toString();
		return createDinamicQuery(sql, entrada);
	}
	
	/*Buscar por Data de Saida*/
	public List<Funcionario>findByDateSaida(LocalDate saida){
		String  sql = new StringBuilder("select f from Funcionario f ")
				.append("where f.dataAdmissao = ?1 ")
				.append("order by f.dataAdmissao asc")
				.toString();
		return createDinamicQuery(sql, saida);
	}

}
