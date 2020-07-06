package br.edu.ufersa.sismart.model.VO;

public class UsuarioVO extends PessoaVO{
	private String login;
	private String senha;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login == null || login.equals("")) {
			System.out.println("Sem login");
			this.login = "Sem login";
		}else {
			if(login.length()<6) {
				System.out.println("Login inválido");
				this.login = "Login inválido";
			}else {
				this.login = login;
			}
		}
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha == null || senha.equals("")) {
			System.out.println("Sem senha cadastrada");
			this.senha = "Sem senha cadastrada";
		}else {
			if(senha.length()<6) {
				System.out.println("Senha inválida");
				this.senha = "Senha inválida";
			}else {
				this.senha = senha;
			}
		}
	}
	
	@Override
	public String toString() {
		String saida;
		saida = super.toString() + "\n\n, login=" + login + "\n\n, senha=" + senha;
		return saida;
	}
	
	public UsuarioVO() {
		
	}
	
	public UsuarioVO(String login, String senha, String nome, String cpf) {
		setLogin(login);
		setSenha(senha);
		super.setNome(nome);
		super.setEmail(cpf);
	}
	
	public UsuarioVO(String login, String senha, String nome,String cpf, String email) {
		setLogin(login);
		setSenha(senha);
		super.setNome(nome);
		super.setEmail(cpf);
		super.setTelefone(email);
	}
	
	public UsuarioVO(String login, String senha, String nome, String email, String telefone, String cpf) {
		setLogin(login);
		setSenha(senha);
		super.setNome(nome);
		super.setEmail(email);
		super.setTelefone(telefone);
		super.setCpf(cpf);
	}
	
}
