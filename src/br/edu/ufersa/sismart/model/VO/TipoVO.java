package br.edu.ufersa.sismart.model.VO;

public class TipoVO {
	private long id;
	private String nome;
	private String formaDeVenda;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		if (id >= 0) {	
			this.id = id;
		} else {
			System.out.println("Necessário atribuir um identificador válido ao tipo.");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Necessário definir um nome para o tipo.");
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
			System.out.println("Necessário determinar forma de venda (Quilo ou unidade).");
		}		
	}
	
		
	@Override
	public String toString() {
		return "TipoVO [id=" + id + ", nome=" + nome + ", formaDeVenda=" + formaDeVenda + "]";
	}

	public TipoVO() {
		
	}
	
	public TipoVO (long id, String nome, String formaDeVenda) {
		setId(id);
		setNome(nome);
		setFormaDeVenda(formaDeVenda);
	}
		
}
