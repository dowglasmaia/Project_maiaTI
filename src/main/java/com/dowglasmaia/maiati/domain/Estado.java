package com.dowglasmaia.maiati.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Informe a UF do Estado")
	@Column(length = 50, nullable = false)
	private String sigla;

	@NotBlank(message = "Informe o nome do Estado")
	@Column(length = 50, nullable = false)
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private List<Funcionario> funcionarios = new ArrayList<>();

	public Estado() {
		// TODO Auto-generated constructor stub
	}

	public Estado(Long id, String sigla,
			 String nome) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

}
