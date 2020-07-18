package br.edu.ufersa.sismart.model.VO;

import java.util.ArrayList;

import br.edu.ufersa.sismart.exception.InsertException;

public class CestaVO {
	private long id;
	ArrayList<ItemVO> itens = new ArrayList<ItemVO>();
	private double valorTotal = 0;
	
	public ArrayList<ItemVO> getItens() {
		return itens;
	}
	public void adicionarItem(ItemVO item) throws InsertException {
		if(item == null) {
			throw new InsertException("Sem itens");
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
	
	public void removerItem(ItemVO item) throws InsertException {
		if(item == null) {
			throw new InsertException("Sem itens");
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
	public void setValorTotal(double valorTotal) throws InsertException {
		if (valorTotal < 0) {
			throw new InsertException("Valor inválido");
		}else {
			this.valorTotal = valorTotal;
		}
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
