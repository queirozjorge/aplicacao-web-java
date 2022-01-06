package br.com.alura.gerenciador.modelo;

public class Usuario {

	private String login;
	private String senha;

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean confirmarLoginESenha(String login, String senha) {
		if (!login.equals(this.login)) {
			return false;
		}
		if (!senha.equals(this.senha)) {
			return false;
		}
		return true;
	}
}
