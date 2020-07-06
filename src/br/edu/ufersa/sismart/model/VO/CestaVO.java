package br.edu.ufersa.sismart.model.VO;

public class CestaVO {
	private ItemVO [] itens;
	private double valorTotal;
	
	public ItemVO[] getItens() {
		return itens;
	}
	public void setItens(ItemVO [] itens) {
		if(itens == null) {
			System.out.println("Sem itens");
		}else {
			this.itens = itens;
		}
	}
	
	public double getValorTotal () {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		if (valorTotal <= 0) {
			System.out.println("Sem compras");
		}else {
			this.valorTotal = valorTotal;
		}
	}
}
