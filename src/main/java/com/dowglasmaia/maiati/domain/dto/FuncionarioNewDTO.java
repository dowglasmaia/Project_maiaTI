package com.dowglasmaia.maiati.domain.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FuncionarioNewDTO {

	private Long id;

	private String nome;

	private String email;

	private String telefone;

	@JsonFormat(shape=JsonFormat.Shape.ANY, pattern="dd-MM-yyyy")
	private String dataAdmissao;

	private String dataDemissao;

	private BigDecimal salario;

	private String logradouro;

	private String numero;

	private String bairro;

	private String cep;

	private String complemento;

	private Long cidadeID;

	private Long estadoID;

	private Long cargoID;

	private Long departamentoID;

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

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(String dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Long getCargoID() {
		return cargoID;
	}

	public void setCargoID(Long cargoID) {
		this.cargoID = cargoID;
	}

	public Long getDepartamentoID() {
		return departamentoID;
	}

	public void setDepartamentoID(Long departamentoID) {
		this.departamentoID = departamentoID;
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

	public Long getCidadeID() {
		return cidadeID;
	}

	public void setCidadeID(Long cidadeID) {
		this.cidadeID = cidadeID;
	}

	public Long getEstadoID() {
		return estadoID;
	}

	public void setEstadoID(Long estadoID) {
		this.estadoID = estadoID;
	}

}
