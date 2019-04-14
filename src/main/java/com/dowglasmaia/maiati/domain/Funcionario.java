package com.dowglasmaia.maiati.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Dowglas Maia 
 * Skype: live:dowglasmaia 
 * E-mail:dowglasmaia@live.com
 *  Linkedin: www.linkedin.com/in/dowglasmaia
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	@NotBlank(message = "Campo Obrigatório")
	private String nome;

	@Column(length = 100)
	@NotBlank(message = "Campo Obrigatório")
	@Email
	private String email;

	@Column(length = 100)
	@NotBlank(message = "Campo Obrigatório")
	private String telefone;

	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Temporal(TemporalType.DATE)
	private Date dataDemissao;

	@NotNull(message = "Campo Obrigatório")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;

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
	private String complemento;

	
	@ManyToOne
	private Cidade cidade;

	@ManyToOne
	private Estado estado;

	@Valid
	@ManyToOne
	private Cargo cargo;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Long id, String nome, String email, String telefone, Date dataAdmissao, Date dataDemissao,
			BigDecimal salario, String logradouro, String numero, String bairro, String cep, String complemento,
			Cidade cidade, Estado estado, Cargo cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.salario = salario;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cargo = cargo;
	}

	// ======== Getters e Setters ================//
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
