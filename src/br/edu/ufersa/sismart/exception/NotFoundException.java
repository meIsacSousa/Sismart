package br.edu.ufersa.sismart.exception;


public class NotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	NotFoundException (String message) {
		super("Não localizado.");
	}
}
