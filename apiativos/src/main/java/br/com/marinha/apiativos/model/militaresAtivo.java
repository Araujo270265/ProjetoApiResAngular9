package br.com.marinha.apiativos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tb_ativo", schema="bieg")
public class militaresAtivo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="cpf", nullable=false, length=11)
	private String cpf;
	
	@Column(name="idPessoal", nullable=false, length=10)
	private String idPessoal;
	
	@Column(name="nome", nullable=false, length=200)
	private String nome;
	
	@Column(name="efetivo", nullable=false, length=3)
	private String efetivo;
	
	public String getEfetivo() {
		return efetivo;
	}

	public void setEfetivo(String efetivo) {
		this.efetivo = efetivo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdPessoal() {
		return idPessoal;
	}

	public void setIdPessoal(String idPessoal) {
		this.idPessoal = idPessoal;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
