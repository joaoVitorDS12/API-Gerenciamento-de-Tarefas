package com.userAndProduct.Apirest.model;

public class ListarDeptEQtdTarefas {
	
	public long idDepartamento;
	public String titulo;
	public long idUser;
	public long idDepartamentoTask;
	public long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public long getIdDepartamentoTask() {
		return idDepartamentoTask;
	}
	public void setIdDepartamentoTask(long idDepartamentoTask) {
		this.idDepartamentoTask = idDepartamentoTask;
	}
	public ListarDeptEQtdTarefas(long idDepartamento, String titulo, long idUser, long idDepartamentoTask) {
		super();
		this.idDepartamento = idDepartamento;
		this.titulo = titulo;
		this.idUser = idUser;
		this.idDepartamentoTask = idDepartamentoTask;
	}

	
	
}
