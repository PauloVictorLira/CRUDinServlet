// PAULO VICTOR LIRA SILVA 	3003906

package com.crudservlet;

public class Emp {  
	private int id, unidadeCompra;
	private double qtdPrevistoMes, precoMaxComprado;
	private String nome,descricao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnidadeCompra() {
		return unidadeCompra;
	}
	public void setUnidadeCompra(int unidadeCompra) {
		this.unidadeCompra = unidadeCompra;
	}
	public double getQtdPrevistoMes() {
		return qtdPrevistoMes;
	}
	public void setQtdPrevistoMes(double qtdPrevistoMes) {
		this.qtdPrevistoMes = qtdPrevistoMes;
	}
	public double getPrecoMaxComprado() {
		return precoMaxComprado;
	}
	public void setPrecoMaxComprado(double precoMaxComprado) {
		this.precoMaxComprado = precoMaxComprado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}  

}  