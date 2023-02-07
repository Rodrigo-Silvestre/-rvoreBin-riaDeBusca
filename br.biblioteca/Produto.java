package br.biblioteca;
/**
 * Classe responsável pela criação de objetos do tipo
 * produto.
 * @author Rodrigo Silvestre
 */
public class Produto {

	private String descricao;
	private int quantidade;
	private double preco;

	/**
	 * Construtor padrão com inicialização de atributos
	 * com (null ou 0).
	 */
	public Produto() {
		this.descricao = null;
		this.preco = 0;
		this.quantidade = 0;
	}
	
	/**
	 * construtor com passagem de parâmetros e inicialização
	 * dos atributos com esses mesmos parâmetros.
	 * @param descricao é a descrição ou nome de um produto.
	 * @param preco é o valor do produto.
	 * @param qtd é a quantidade de produtos.
	 */
	public Produto(String descricao, double preco, int qtd) {
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = qtd;
	}
	
	/**
	 * Método responsável pelo retorno
	 * do valor do atributo "descrição".
	 * @return descricao do produto.
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Método resposável por definir um valor
	 * para o atributo "descrição".
	 * Que será recebido por um parâmetro.
	 * @param descricao descrição ou nome do produto.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Método responsável por definir um valor
	 * para o atributo "quantidade".
	 * Que será recebido por um parâmetro.
	 * Gera um retorno boleano, verdadeiro caso o parametro
	 * passado cumpra com as especificações, e falso
	 * caso contrário. 
	 * @param quantidade quantidade do produto
	 * @return verdadeiro ou falso.
	 */
	public boolean setQtd(int quantidade) {
		if (quantidade < 0) return false;
		this.quantidade = quantidade;
		return true;
	}

	/**
	 * Método responsável por definir um valor
	 * para o atributo "preço".
	 * Que será recebido por um parâmetro.
	 * Gera um retorno boleano, verdadeiro caso o parametro
	 * passado cumpra com as especificações, e falso
	 * caso contrário. 
	 * @param preco preço do produto
	 * @return verdadeiro ou falso.
	 */
	public boolean setPreco(double preco) {
		if (preco <= 0) return false;
		this.preco = preco;
		return true;
	}
	
	@Override
	public String toString() {
		return "Descrição: " + getDescricao() + "\n" +
		"Preço: " + this.preco + "\n" +
    	"Quantidade: " + this.quantidade + "\n";	
	}
}
