package br.edu.ufersa.sismart.model.VO;

import br.edu.ufersa.sismart.exception.InsertException;

public class UsuarioVO extends PessoaVO{
	private String login;
	private String senha;
	private long idUsu;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) throws InsertException {
		if(login == null || login.equals("")) {
			throw new InsertException("Necessário informar um login válido");
		}else {
			if(login.length()>=6) {
				this.login = login;
				
			}else throw new InsertException("Login deve ter no minimo 6 caracteres.");
		}
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) throws InsertException {
		if(senha == null || senha.equals("")) {
			throw new InsertException("Senha inválida, necessário especificar senha.");
		}else {
			if(senha.length()>=6) {
				this.senha = senha;
				
			}else throw new InsertException("Senha deve ter no minimo 6 caracteres.");
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
	
	public UsuarioVO(String login, String senha) throws InsertException{
		setLogin(login);
		setSenha(senha);
	}
	
	public UsuarioVO(String login, String senha, String nome, String cpf) throws InsertException {
		setLogin(login);
		setSenha(senha);
		super.setNome(nome);
		super.setEmail(cpf);
	}
	
	public UsuarioVO(String login, String senha, String nome,String cpf, String email) throws InsertException {
		setLogin(login);
		setSenha(senha);
		super.setNome(nome);
		super.setEmail(cpf);
		super.setTelefone(email);
	}
	
	public UsuarioVO(String login, String senha, String nome, String email, String telefone, String cpf) throws InsertException {
		setLogin(login);
		setSenha(senha);
		super.setNome(nome);
		super.setEmail(email);
		super.setTelefone(telefone);
		super.setCpf(cpf);
	}
	public long getIdUsu() {
		return idUsu;
	}
	public void setIdUsu(long idUsu) {
		this.idUsu = idUsu;
	}
	
}
