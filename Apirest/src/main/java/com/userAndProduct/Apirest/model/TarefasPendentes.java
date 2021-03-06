package com.userAndProduct.Apirest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TarefasPendentes {
	
	public long idUser;
	public String prazo;
	
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getPrazo() {
		return prazo;
	}
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	public TarefasPendentes(long idUser, String prazo) {
		super();
		this.idUser = idUser;
		this.prazo = prazo;
	}


	
	
}
