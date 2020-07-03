package br.edu.ufersa.sismart.model.VO;

public class TipoVO {
	String id;
	String nome;
	String formaDeVenda;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		if (id != null && !id.equals("")) {	
			this.id = id;
		} else {
			System.out.println("Necessário atribuir um identificador ao tipo");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (id != null && !id.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Necessário definir um nome para o tipo");
		}
	}
	
	public String getFormaDeVenda() {
		return formaDeVenda;
	}
	
	public void setFormaDeVenda(String formaDeVenda) {
		if (formaDeVenda != null) {
			if (formaDeVenda.equalsIgnoreCase("Quilo") || formaDeVenda.equalsIgnoreCase("kg")) {
				this.formaDeVenda = "Quilo";
			} else if (formaDeVenda.equalsIgnoreCase("Quantidade")) {
				this.formaDeVenda = "Quantidade";
			} else {
				System.out.println("Valor inválido");
			}
		} else {
			System.out.println("Necessário determinar forma de venda (Quilo ou unidade)");
		}		
	}
	
		
	@Override
	public String toString() {
		return "TipoVO [id=" + id + ", nome=" + nome + ", formaDeVenda=" + formaDeVenda + "]";
	}

	public TipoVO() {
		
	}
	
	public TipoVO (String id, String nome, String formaDeVenda) {
		setId(id);
		setNome(nome);
		setFormaDeVenda(formaDeVenda);
	}
		
}
