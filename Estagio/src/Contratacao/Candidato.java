package Contratacao;

public class Candidato extends Pessoa {
	
	private int idade;
	private String vaga;
	
	public Candidato(String nome, String sobrenome, String CPF, String dataNascimento, int idade, String vaga) {
		super(nome, sobrenome, CPF, dataNascimento);
		this.idade = idade;
		this.vaga = vaga;
	}
	
	public Candidato() {
		super();
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getVaga() {
		return vaga;
	}

	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	
	
}
