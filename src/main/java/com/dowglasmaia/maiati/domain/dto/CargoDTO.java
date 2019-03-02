package com.dowglasmaia.maiati.domain.dto;

import java.io.Serializable;

import com.dowglasmaia.maiati.domain.Cargo;

public class CargoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String departamento;

	public CargoDTO() {

	}

	public CargoDTO(Cargo obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.departamento = obj.getDepartamento().getNome();
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
