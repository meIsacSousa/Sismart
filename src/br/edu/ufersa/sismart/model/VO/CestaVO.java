package br.edu.ufersa.sismart.model.VO;

public class CestaVO {
	private ItemVO [] itens;
	private double valorTotal = 0;
	
	public ItemVO[] getItens() {
		return itens;
	}
	public void adicionarItem(ItemVO item) {
		if(item == null) {
			System.out.println("Sem itens");
		}else {
			for(int i = 0; i < itens.length; i++) {
				if(itens[i] == null) {
					itens[i] = item;
					break;
				}
			}
			valorTotal += item.getPreco() * item.getQuantidadeCompra();
		}
	}
	
	public void removerItem(ItemVO item) {
		if(item == null) {
			System.out.println("Sem itens");
		}else {
			for(int i = 0; i < itens.length; i++) {
				if(itens[i] == item) {
					itens[i] = null;
					break;
				}
			}
			valorTotal -= item.getPreco() * item.getQuantidadeCompra();
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
