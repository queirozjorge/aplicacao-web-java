package br.com.alura.gerenciador.modelo;

import java.util.Date;

public class Empresa {

	private Integer id;
	private String nome;
	private String cnpj;
	private Date data = new Date();

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public void setData(Date dataCadastro) {
		this.data = dataCadastro;
	}
	public Date getData() {
		return data;
	}
}
