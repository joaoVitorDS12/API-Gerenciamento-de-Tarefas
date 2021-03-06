package com.userAndProduct.Apirest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListaPessoas {
	
	public String name;
	public String tituloDepartamento;
	public long horasGastasTarefas;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTituloDepartamento() {
		return tituloDepartamento;
	}
	public void setTituloDepartamento(String tituloDepartamento) {
		this.tituloDepartamento = tituloDepartamento;
	}
	public double getHorasGastasTarefas() {
		return horasGastasTarefas;
	}
	public void setHorasGastasTarefas(long horasGastasTarefas) {
		this.horasGastasTarefas = horasGastasTarefas;
	}
	public ListaPessoas(String name, String tituloDepartamento, long horasGastasTarefas) {
		super();
		this.name = name;
		this.tituloDepartamento = tituloDepartamento;
		this.horasGastasTarefas = horasGastasTarefas;
	}

	
}
