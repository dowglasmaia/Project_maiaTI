package com.dowglasmaia.maiati.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.dowglasmaia.maiati.domain.Funcionario;

public class FuncionarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Date dataAdmissao;
	private Date dataDemissao;
	private BigDecimal salario;
	private String cargo;
	private String cidade;

	public FuncionarioDTO() {

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
		this.cidade = obj.getEndereco().getCidade().getNome();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
