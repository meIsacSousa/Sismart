package br.edu.ufersa.sismart.exception;

public class AutenticationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	AutenticationException (String message) {
		super("Login e/ou senha incorreto");
	}
}
