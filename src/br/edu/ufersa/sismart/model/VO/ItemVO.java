package br.edu.ufersa.sismart.model.VO;

public class ItemVO {
	private long id;
	private String marca;
	private String nome;
	private String codigoDeBarras;
	private int quantidadeEmEstoque;
	private double preco;
	private TipoVO tipo;
	private int quantidadeCompra;
	private long idCesta;

	
	public long getIdCesta() {
		return idCesta;
	}

	public void setIdCesta(long idCesta) {
		if (idCesta >= 0) {
			this.idCesta = idCesta;
		} else {
			System.out.println("Valor inválido");
		}
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if(id >= 0) {
			this.id = id;
		} else {
			System.out.println("Valor inválido");
		}
		
	}

	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		if (marca != null && !marca.equals("")) {
			this.marca = marca;
		} else {
			System.out.println("Necessário definir um valor válido para a marca do produto.");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Necessário definir um valor válido para o nome do produto.");
		}
	}
	
	public String getCodigoDeBarras() {
			return codigoDeBarras;	
	}
	
	public void setCodigoDeBarras(String codigoDeBarras) {
		if (codigoDeBarras != null && !codigoDeBarras.equals("")) {
			codigoDeBarras = codigoDeBarras.replaceAll("[^0-9]","");
			if (codigoDeBarras.length() == 13) {
				this.codigoDeBarras = codigoDeBarras;
			} else {
				System.out.println("Código de barras inválido.");
			}
		} else {
			System.out.println("Valor inválido.");
		}
	}
	
	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	
	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		if (quantidadeEmEstoque >= 0) {
			this.quantidadeEmEstoque = quantidadeEmEstoque;
		} else {
			System.out.println("Quantidade em estoque não pode ser negativa.");
		}
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		if (preco >= 0) {
			this.preco = preco;
		} else {
			System.out.println("Preço do produto não pode ser negativo.");
		}
	}
	
	public TipoVO getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoVO tipo) {
		if (tipo != null) {
			this.tipo = tipo;
		} else {
			System.out.println("Necessário definir um tipo para o produto.");
		}		
	}
	
	public int getQuantidadeCompra() {
		return quantidadeCompra;
	}
	
	public void setQuantidadeCompra(int quantidadeCompra) {
		if (quantidadeCompra >= 0) {
			this.quantidadeCompra = quantidadeCompra;
		} else {
			System.out.println("A quantidade de produtos não pode ser negativa.");
		}
	}

	@Override
	public String toString() {
		return "ItemVO [marca=" + marca + ", codigoDeBarras=" + codigoDeBarras + ", quantidadeEmEstoque="
				+ quantidadeEmEstoque + ", preco=" + preco + ", tipo=" + tipo + ", quantidadeCompra=" + quantidadeCompra
				+ "]";
	}

	public ItemVO(String marca, String nome, String codigoDeBarras, int quantidadeEmEstoque, double preco, TipoVO tipo,
			int quantidadeCompra) {
		setMarca(marca);
		setNome(nome);
		setCodigoDeBarras(codigoDeBarras);
		setQuantidadeEmEstoque(quantidadeEmEstoque);
		setPreco(preco);
		setTipo(tipo);
		setQuantidadeCompra(quantidadeCompra);
	}
	
	
	public ItemVO(String marca, String nome,String codigoDeBarras, TipoVO tipo) {
		setMarca(marca);
		setNome(nome);
		setCodigoDeBarras(codigoDeBarras);
		setTipo(tipo);
	}

	public ItemVO () {
		
	}
	
	
}
