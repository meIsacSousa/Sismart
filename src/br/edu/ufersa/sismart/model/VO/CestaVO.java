package br.edu.ufersa.sismart.model.VO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufersa.sismart.exception.InsertException;

public class CestaVO {
	private long id;
	private List<ItemVO> itens = new ArrayList<ItemVO>();
	private double valorTotal = 0;
	
	public List<ItemVO> getItens() {
		return itens;
	}
	public void adicionarItem(ItemVO item) throws InsertException {
		if(item == null) {
			throw new InsertException("Sem itens");
		}else itens.add(item);
			valorTotal += item.getPreco() * item.getQuantidadeCompra();
	}
	
	
	@Override
	public String toString() {
		return "CestaVO [id=" + id + ", valorTotal=" + valorTotal + "]";
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
			this.valorTotal = valorTotal;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) throws InsertException{
		if (id >= 0) {
			this.id = id;
		} else throw new InsertException("Id informado inválido");
		
	}
	
}
