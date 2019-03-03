package com.dowglasmaia.maiati.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.dowglasmaia.maiati.domain.Funcionario;

public class FuncionarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private LocalDate dataAdmissao;
	private LocalDate dataDemissao;
	private BigDecimal salario;
	private String cargo;

	public FuncionarioDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FuncionarioDTO(Funcionario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.dataAdmissao = obj.getDataAdmissao();
		this.dataDemissao = obj.getDataDemissao();
		this.salario = obj.getSalario();
		this.cargo = obj.getCargo().getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
