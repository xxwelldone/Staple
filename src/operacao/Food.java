package operacao;

public class Food {

	private int id;
	private String nome;
	private String origem;
	private int unidade;
	private double preco;
	private String fabricante;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Food(String nome, String origem, int unidade, double preco, String fabricante) {
		super();
		this.nome = nome;
		this.origem = origem;
		this.unidade = unidade;
		this.preco = preco;
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item: " + nome + "\n");
		sb.append("Id atual do produto: " + id + "\n");
		sb.append("Origem: " + origem + "\n");
		sb.append("Quantidade em Estoque: " + unidade + "\n");
		sb.append("Preço unitário: " + preco + "\n");
		sb.append("Produzido por: " + fabricante + "\n");
		return sb.toString();
	}

}
