package br.edu.ufersa.sismart.model.VO;

public class NotaVO {
	private long id;
	private CestaVO cesta;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		if (id >= 0) {
			this.id = id;
		} else {
			System.out.println("Necessário atribuir um identificador válido para a nota.");
		}	
	}
	
	public CestaVO getCesta() {
		return cesta;
	}
	
	public void setCesta(CestaVO cesta) {
		if (cesta != null) {
			this.cesta = cesta;
		} else {
			System.out.println("Cesta de compras está vazia.");
		}
	}
	
	@Override
	public String toString() {
		return "NotaVO [id=" + id + ", cesta=" + cesta + "]";
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
