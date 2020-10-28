package br.com.marinha.apiativos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_profissao", schema="bieg")
public class profissao {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="codativo", nullable=false, length=5)
	private int codativo;
	
	@Column(name="cpf", nullable=false, length=11)
	private String cpf;
	
	@Column(name="idPessoal", nullable=false, length=10)
	private String idPessoal;
	
	@Column(name="nome", nullable=false, length=200)
	private String nome;
	
	@Column(name="profissao", nullable=false, length=200)
	private String profissao;
	
	@Column(name="dtAdm", nullable=false)
	private String dtAdm;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCodativo() {
		return codativo;
	}

	public void setCodativo(int codativo) {
		this.codativo = codativo;
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

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getDtAdm() {
		return dtAdm;
	}

	public void setDtAdm(String dtAdm) {
		this.dtAdm = dtAdm;
	}
	
	
	
	
}
