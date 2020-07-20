package br.edu.ufersa.sismart.model.DAO;

import java.sql.SQLException;

import br.edu.ufersa.sismart.exception.InsertException;
import br.edu.ufersa.sismart.model.VO.ItemVO;
import br.edu.ufersa.sismart.model.VO.TipoVO;

@SuppressWarnings("unused")
public class Teste {

	public static void main(String[] args) {
	
		ItemVO ivo = new ItemVO();
		
		try {
			ivo.setCodigoDeBarras("");
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
