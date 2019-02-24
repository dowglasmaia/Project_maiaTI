package com.dowglasmaia.maiati.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.dowglasmaia.maiati.domain.enums.UF;

@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 50, nullable = false)
	private String logradouro;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 10, nullable = false)
	private String numero;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 50, nullable = false)
	private String bairro;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 12, nullable = false)
	private String cep;

	@Column(length = 50)
	private String Complemento;

	@NotBlank(message = "Campo Obrogatório")
	@Column(length = 50, nullable = false)
	private String Cidade;

	@NotNull(message = "Informe uma UF para a Cidade")
	@Column(length = 2, nullable = false)
	@Enumerated(EnumType.STRING)
	private UF uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
