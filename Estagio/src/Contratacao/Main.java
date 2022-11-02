package Contratacao;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		
		Candidato candidato = new Candidato();
		
		List<Pessoa> dadosPessoa = new ArrayList<Pessoa>();
		
		dadosPessoa.add(pessoa);
		pessoa.setCPF("Arroz");
		System.out.println(dadosPessoa.get(0).getCPF());
		
		if(pessoa.getCPF() == null) {
			System.out.println("parou");
			
		}
		/*if(idade > 18) {
		System.out.println("Maior de idade!");
	}else {
		System.out.println("Menor de idade!");
	}*/
	}
}
