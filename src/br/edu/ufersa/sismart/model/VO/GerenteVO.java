package br.edu.ufersa.sismart.model.VO;

import br.edu.ufersa.sismart.exception.InsertException;

public class GerenteVO extends UsuarioVO{
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) throws InsertException {
		if(id >= 0) {
			this.id = id;
		} else throw new InsertException("Necessário atribuir valor válido para o id");
		
	}
}
