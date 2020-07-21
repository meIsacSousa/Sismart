package br.edu.ufersa.sismart.model.VO;

import br.edu.ufersa.sismart.exception.InsertException;

public class NotaVO {
	private long id;
	private CestaVO cesta;
	private long idCesta;
	
	public long getIdCesta() {
		return idCesta;
	}

	public void setIdCesta(long idCesta) throws InsertException {
		if (idCesta >= 0) {
			this.idCesta = idCesta;
		} else throw new InsertException("Necessário atribuir identificador válido.");
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) throws InsertException {
		if (id >= 0) {
			this.id = id;
		} else throw new InsertException("Necessário atribuir um identificador válido para a nota.");
	}
	
	public CestaVO getCesta() {
		return cesta;
	}
	
	public void setCesta(CestaVO cesta) throws InsertException {
		if (cesta != null) {
			this.cesta = cesta;
		} else throw new InsertException("Cesta de compras está vazia.");
	}
	
	@Override
	public String toString() {
		return "Nota [id=" + id + ", cesta=" + cesta + "]";
	}

	public NotaVO(long id, CestaVO cesta) {
		this.id = id;
		this.cesta = cesta;
	}
	
	public NotaVO(CestaVO cesta) {
		this.cesta = cesta;
	}

	public NotaVO() {
		
	}
		
	
}
