package br.edu.ufersa.sismart.exception;

import java.sql.SQLException;

public class InsertException extends SQLException {
	
	private static final long serialVersionUID = 1L;
	
	InsertException (String message){
		super(message);
	}
	
}
