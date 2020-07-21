package br.edu.ufersa.sismart.model.VO;

import br.edu.ufersa.sismart.exception.InsertException;

public class ItemVO {
	private long id;
	private String marca;
	private String nome;
	private String codigoDeBarras;
	private int quantidadeEmEstoque;
	private double preco;
	private TipoVO tipo;
	private int quantidadeCompra;
	private long idCesta = 1;

	
	public long getIdCesta() {
		return idCesta;
	}

	public void setIdCesta(long idCesta) throws InsertException  {
		if (idCesta >= 0) {
			this.idCesta = idCesta;
		} else throw new InsertException("Nenhum valor valido para o identificador da cesta.");		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) throws InsertException {
		if(id >= 0) {
			this.id = id;
		} else throw new InsertException("Valor inválido para o ID.");		
	}

	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) throws InsertException {
		if (marca != null && !marca.equals("")) {
			this.marca = marca;
		} else throw new InsertException("Necessário definir um valor válido para a marca do produto.");
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws InsertException {
		if (nome != null && !nome.equals("")) {
			this.nome = nome;
		} else throw new InsertException("Necessário definir um valor válido para o nome do produto.");
	}
	
	public String getCodigoDeBarras() {
			return codigoDeBarras;	
	}
	
	public void setCodigoDeBarras(String codigoDeBarras) throws InsertException {
		if (codigoDeBarras != null && !codigoDeBarras.equals("")) {
			codigoDeBarras = codigoDeBarras.replaceAll("[^0-9]","");
			if (codigoDeBarras.length() == 13) {
				this.codigoDeBarras = codigoDeBarras;
			} else throw new InsertException("Código de barras inválido.");
		} else throw new InsertException("Valor inválido.");
	}
	
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) throws InsertException {
		if (quantidadeEmEstoque >= 0) {
			this.quantidadeEmEstoque = quantidadeEmEstoque;
		} else throw new InsertException("Quantidade em estoque não pode ser negativa.");
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) throws InsertException {
		if (preco >= 0) {
			this.preco = preco;
		} else throw new InsertException("Preço do produto não pode ser negativo.");
	}
	
	public TipoVO getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoVO tipo) throws InsertException {
		if (tipo != null) {
			this.tipo = tipo;
		} else throw new InsertException("Necessário definir um tipo para o produto.");		
	}
	
	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}
	
	public void setQuantidadeCompra(int quantidadeCompra) throws InsertException {
		if (quantidadeCompra >= 0) {
			this.quantidadeCompra = quantidadeCompra;
		} else throw new InsertException("A quantidade de produtos não pode ser negativa.");
	}

	@Override
	public String toString() {
		return "Item [marca=" + marca + ", codigoDeBarras=" + codigoDeBarras + ", quantidadeEmEstoque="
				+ quantidadeEmEstoque + ", preco=" + preco + ", tipo=" + tipo + ", quantidadeCompra=" + quantidadeCompra
				+ "]";
	}

	public ItemVO(String marca, String nome, String codigoDeBarras, int quantidadeEmEstoque, double preco, TipoVO tipo,
			int quantidadeCompra) throws InsertException {
		setMarca(marca);
		setNome(nome);
		setCodigoDeBarras(codigoDeBarras);
		setQuantidadeEmEstoque(quantidadeEmEstoque);
		setPreco(preco);
		setTipo(tipo);
		setQuantidadeCompra(quantidadeCompra);
	}
	
	
	public ItemVO(String marca, String nome,String codigoDeBarras, TipoVO tipo) throws InsertException {
		setMarca(marca);
		setNome(nome);
		setCodigoDeBarras(codigoDeBarras);
		setTipo(tipo);
	}

	public ItemVO () {
		
	}
	
	
}
