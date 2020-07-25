package br.edu.ufersa.sismart.model.VO;

import br.edu.ufersa.sismart.exception.InsertException;

public class TipoVO {
	private long id;
	private String nome;
	private String formaDeVenda;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) throws InsertException {
		if (id >= 0) {	
			this.id = id;
		} else throw new InsertException("Necessário atribuir um identificador válido ao tipo.");
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws InsertException {
		if (nome != null && !nome.equals("")) {
			this.nome = nome;
		} else throw new InsertException("Necessário definir um nome para o tipo.");
	}
	
	public String getFormaDeVenda() {
		return formaDeVenda;
	}
	
	public void setFormaDeVenda(String formaDeVenda) throws InsertException {
		if (formaDeVenda != null) {
			if (formaDeVenda.equalsIgnoreCase("Quilo") || formaDeVenda.equalsIgnoreCase("kg")) {
				this.formaDeVenda = "Quilo";
			} else if (formaDeVenda.equalsIgnoreCase("Quantidade")) {
				this.formaDeVenda = "Quantidade";
			} else throw new InsertException("Valor inválido");
		} else throw new InsertException("Necessário determinar forma de venda (Quilo ou unidade).");	
	}
	
		
	@Override
	public String toString() {
		return nome + ": " + formaDeVenda;
	}

	public TipoVO() {
		
	}
	
	public TipoVO (long id, String nome, String formaDeVenda) throws InsertException {
		setId(id);
		setNome(nome);
		setFormaDeVenda(formaDeVenda);
	}
		
}
