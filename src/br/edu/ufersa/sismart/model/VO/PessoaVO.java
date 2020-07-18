package br.edu.ufersa.sismart.model.VO;
import java.util.regex.*;

import br.edu.ufersa.sismart.exception.InsertException;

public abstract class PessoaVO {
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private Long idPessoa;
	
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long id) throws InsertException {
		if (id >= 0) {
			this.idPessoa = id;
		} else throw new InsertException("Valor informado é inválido.");
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws InsertException {
		if(nome == null || nome.equals("")) {
			throw new InsertException("Nome não atribuido");
		}else {
			this.nome = nome;
		}
	}
	
	public String getEmail() {
		return email; 
	}
	public void setEmail(String email) throws InsertException {
		if(email == null || email.equals("")) {
			System.out.println("Sem email");
			this.email = "Sem email";
		}else{
			if (email != null && email.length() > 0) {
		        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		        Matcher matcher = pattern.matcher(email);
		        if (matcher.matches()) {
		        	this.email = email;
		        }
		    }else throw new InsertException("email inválido");
		}
	}
	
	public String getTelefone() {
		return telefone; 
	}
	public void setTelefone(String telefone) throws InsertException {
		if(telefone == null || telefone.equals("")) {
			System.out.println("Sem email");
			this.telefone = "Sem telefone";
		}else {
			if(telefone.length() != 10 || telefone.length() != 11) {
				throw new InsertException("Número inválido.");
			}else {
				this.telefone = telefone;
			}
		}
	}
	
	public String getCpf() {
		return cpf; 
	}
	public void setCpf(String cpf) throws InsertException {
		if(cpf == null || cpf.equals("")) {
			throw new InsertException("Necessário informar o CPF.");
		}else{
			if(cpf.length() != 11) {
				throw new InsertException("Necessário informar o CPF.");
			}else {
				this.cpf = cpf;
			}
		}
	}
	
	@Override
	public String toString() {
		String saida;
		saida = "Pessoa: \n nome=" + nome + "\n, email=" + email + "\n, telefone="
				+ telefone + ",\n cpf=" + cpf;
		return saida;
	}
	
	public PessoaVO () {
		
	}
	public PessoaVO (String nome, String cpf) throws InsertException {
		setNome(nome);
		setEmail(cpf);
	}
	public PessoaVO (String nome, String cpf, String email) throws InsertException {
		setNome(nome);
		setEmail(cpf);
		setTelefone(email);
	}
	public PessoaVO(String nome, String cpf, String email, String telefone) throws InsertException {
		setNome(nome);
		setEmail(cpf);
		setTelefone(email);
		setCpf(telefone);
	}
}
