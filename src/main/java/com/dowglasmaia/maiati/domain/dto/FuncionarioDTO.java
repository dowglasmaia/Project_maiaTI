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
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;
	private String cidade;
	private String uf;

	public FuncionarioDTO() {

	}

	public FuncionarioDTO(Funcionario obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.dataAdmissao = obj.getDataAdmissao();
		this.dataDemissao = obj.getDataDemissao();
		this.salario = obj.getSalario();
		this.cargo = obj.getCargo().getNome();
		this.logradouro = obj.getEndereco().getLogradouro();
		this.numero = obj.getEndereco().getNumero();
		this.bairro = obj.getEndereco().getBairro();
		this.cep = obj.getEndereco().getCep();
		this.complemento = obj.getEndereco().getComplemento();
		this.cidade = obj.getEndereco().getCidade();
		this.uf = obj.getEndereco().getUf().getSigla();
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
