package com.dowglasmaia.maiati.domain.func.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.dowglasmaia.maiati.domain.Cargo;
import com.dowglasmaia.maiati.domain.Cidade;
import com.dowglasmaia.maiati.domain.Estado;
import com.dowglasmaia.maiati.domain.Funcionario;

public class FuncionarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Date dataAdmissao;
	private Date dataDemissao;
	private BigDecimal salario;
	private Cargo cargo;

	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String complemento;

	private Cidade cidade;
	private Estado estado;

	
	public FuncionarioDTO() {	}

	public FuncionarioDTO(Funcionario obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.dataAdmissao = obj.getDataAdmissao();
		this.dataDemissao = obj.getDataDemissao();
		this.salario = obj.getSalario();
		this.cargo = obj.getCargo();
		this.logradouro = obj.getEndereco().getLogradouro();
		this.numero = obj.getEndereco().getNumero();
		this.bairro = obj.getEndereco().getBairro();
		this.cep = obj.getEndereco().getCep();
		this.complemento = obj.getEndereco().getComplemento();
		this.cidade = obj.getEndereco().getCidade();
		this.estado = obj.getEndereco().getCidade().getUf();

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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
