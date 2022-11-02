package Contratacao;

public class Pessoa {
	
	private String nome;
	
	private String sobrenome;
	
	private String CPF;
	
	private String dataNascimento;

	public Pessoa(String nome, String sobrenome, String cPF, String dataNascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		CPF = cPF;
		this.dataNascimento = dataNascimento;
	}
	
	public Pessoa() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
