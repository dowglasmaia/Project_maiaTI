package com.dowglasmaia.maiati.domain.cargo.dto;

import java.io.Serializable;

import com.dowglasmaia.maiati.domain.Cargo;
import com.dowglasmaia.maiati.domain.Departamento;

public class CargoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private Departamento departamento;

	
	public CargoDTO() {
		// TODO Auto-generated constructor stub
	}

	public CargoDTO(Cargo obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.departamento = obj.getDepartamento();
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
