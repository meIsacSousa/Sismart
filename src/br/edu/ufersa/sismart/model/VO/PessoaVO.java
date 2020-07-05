package br.edu.ufersa.sismart.model.VO;
import java.util.regex.*;

public class PessoaVO {
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome == null || nome.equals("")) {
			System.out.println("Sem nome");
			this.nome = "Sem nome";
		}else {
			this.nome = nome;
		}
	}
	
	public String getEmail() {
		return email; 
	}
	public void setEmail(String email) {
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
		    }else {
		    	System.out.println("email inválido");
				this.email = "email inválido";
			}
		}
	}
	
	public String getTelefone() {
		return telefone; 
	}
	public void setTelefone(String telefone) {
		if(telefone == null || telefone.equals("")) {
			System.out.println("Sem email");
			this.telefone = "Sem telefone";
		}else {
			if(telefone.length() != 10 || telefone.length() != 11) {
				System.out.println("telefone inválido");
				this.telefone = "telefone inválido";
			}else {
				this.telefone = telefone;
			}
		}
	}
	
	public String getCpf() {
		return cpf; 
	}
	public void setCpf(String cpf) {
		if(cpf == null || cpf.equals("")) {
			System.out.println("Sem CPF");
			this.cpf = "Sem CPF";
		}else{
			if(cpf.length() != 11) {
				System.out.println("CPF inválido");
				this.cpf = "CPF inválido";
			}else {
				this.cpf = cpf;
			}
		}
	}
	
	@Override
	public String toString() {
		String saida;
		saida = "PessoaVO: \n nome=" + nome + "\n, email=" + email + "\n, telefone="
				+ telefone + ",\n cpf=" + cpf;
		return saida;
	}
	
	public PessoaVO () {
		
	}
	public PessoaVO (String nome, String email) {
		setNome(nome);
		setEmail(email);
	}
	public PessoaVO (String nome, String email, String telefone) {
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
	}
	public PessoaVO(String nome, String email, String telefone, String cpf) {
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		setCpf(cpf);
	}
}
