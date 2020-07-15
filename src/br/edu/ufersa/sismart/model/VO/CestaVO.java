package br.edu.ufersa.sismart.model.VO;

import java.util.ArrayList;

public class CestaVO {
	ArrayList<ItemVO> itens = new ArrayList<ItemVO>();
	private double valorTotal = 0;
	
	public ArrayList<ItemVO> getItens() {
		return itens;
	}
	public void adicionarItem(ItemVO item) {
		if(item == null) {
			System.out.println("Sem itens");
		}else {
			for(int i = 0; i < itens.size(); i++) {
				if(itens.get(i) == null) {
					itens.add(item);
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
			for(int i = 0; i < itens.size(); i++) {
				if(itens.get(i) == item) {
					itens.remove(i);
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
