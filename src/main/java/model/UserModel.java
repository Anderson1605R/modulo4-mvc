package model;

public class UserModel {
	private String nome;
	private String cpf;
	private String email;
	private int idUser;
	private String senha;
	
	public UserModel(String nome, String cpf, String email, int idUser, String senha ) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.idUser = idUser;
		this.senha = senha;
	}
	
	public UserModel() {};
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return idUser;
	}

	public void setId(int idUser) {
		this.idUser = idUser;
	}
}
