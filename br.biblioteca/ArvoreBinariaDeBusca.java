package br.biblioteca;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Classe responsável pela criação da
 * Estrutura de dados Árvore Binária 
 * de Busca.
 * @author Rodrigo Silvestre
 */
public class ArvoreBinariaDeBusca {

	/**
	 * Classe reposável pela criação
	 * do objeto Nó.
	 * É uma classe privada, não pode
	 * ser instanciada fora da classe
	 * externa que a possui.
	 */
	private class No {

		private No pai;
		private No esquerda;
		private No direita;
		private Produto dados;
		
		/**
		 * Construtor padrão que
		 * recebe o apenas um único 
		 * parâmetro e inicializa os
		 * outro atributos com valores
		 * nulos.
		 * @param dados é um produto.
		 */
		public No(Produto dados) {
			this.dados = dados;
			this.pai = null;
			this.esquerda = null;
			this.direita = null;
		}
	}
	
	/* Atributos da Árvore Binária de Busca. */
	private No raiz;
	private int tamanho;

	/**
	 * Construtor padrão que inicializa
	 * todos os atributos da árvore binária
	 * de busca com valores nulos (null ou 0).
	 */
	public ArvoreBinariaDeBusca() {
		this.raiz = null;
		this.tamanho = 0;
	}
	
	/**
	 * Verifica se a árvore binária de busca
	 * está vazia.
	 * @return verdadeiro ou false.
	 */
	public boolean vazio() {
		return this.raiz == null;
	}

	/**
	 * Verifica o tamanho da árvore binnária de busca.
	 * (A quantidade de nós armazenado).
	 * @return o tamanho da arvore.
	 */
	public int length() {
		return this.tamanho;
	}
	
	/**
	 * Adiciona um Nó do tipo produto
	 * na árvore bionária de busca.
	 * caso a inserção aconteça, o 
	 * método retorna verdadeiro, caso 
	 * contrário retornara falso.
	 * @param objeto é um produto.
	 * @return verdadeiro ou falso.
	 */
	public boolean adicionar(Produto objeto) {
		if (objeto == null) return false;
		No aux = new No(objeto);
		if (vazio()) {
			this.raiz = aux;
		}
		else {
			No anterior, atual;
			anterior = atual = raiz;
			while (atual != null) {
				if (objeto.getDescricao().compareTo(atual.dados.getDescricao()) < 0) {
					anterior = atual;
					atual = atual.esquerda;
				}
				else {
					if (objeto.getDescricao().compareTo(atual.dados.getDescricao()) > 0) {
						anterior = atual;
						atual = atual.direita;
					}
					else {
						return false;
					}
				}
			}
			aux.pai = anterior;
			if (objeto.getDescricao().compareTo(anterior.dados.getDescricao()) < 0) {
				anterior.esquerda = aux;
			}
			else {
				anterior.direita = aux;
			}
		}
		tamanho++;
		return true;
	}
	
	/**
	 * Remove Nó do tipo produtoda árvore
	 * binária de busca e retorna o produto,
	 * caso a remoção tenha sido bem sucedida,
	 * caso contrário é retornado null.
	 * @param objeto é um produto.
	 * @return o produto removido ou null.
	 */
	public Produto remover(Produto objeto) {
		Produto aux = null;
		No z = consultar(objeto);
		if (z != null) {
			aux = z.dados;
			No x = null;
			No y = null;
			if (z.esquerda == null || z.direita == null) {
				y = z;
			}
			else {
				y = sucessor(z);
			}
			if (y.esquerda != null) {
				x = y.esquerda;
			} 
			else {
				x = y.direita;
			}
			if (x != null) {
				x.pai = y.pai;
			}
			if (y.pai == null) {
				raiz = x;
				if (x != null) {
					x.pai = null;
				}
			}
			else {
				if (y == y.pai.esquerda) {
					y.pai.esquerda = x;
				}				
				else {
					y.pai.direita = x;
				}
			}
			if (y != z) {
				z.dados = y.dados;
			}
			tamanho--;
		}
		return aux;
	}
	
	/**
	 * consulta um nó na árvore binária de busca,
	 * retornando o próprio nó desse objeto, caso 
	 * ele exista na árvore, caso contrário será
	 * retornado null.
	 * @param objeto é um produto.
	 * @return um nó ou null.
	 */
	private No consultar(Produto objeto) {
		if (objeto == null || vazio()) return null;
		No atual;
		atual = raiz;
		while (atual != null) {
			if (objeto.getDescricao().compareTo(atual.dados.getDescricao()) < 0) {
				atual = atual.esquerda;
			}
			else {
				if (objeto.getDescricao().compareTo(atual.dados.getDescricao()) > 0) {
					atual = atual.direita;
				}
				else {
					return atual;
				}
			}
		}
		return null;
	}
	
	/**
	 * Pesquisa um produto dentro da árvore binária de busca.
	 * Retorna o produto caso a consulta dele
	 * retorne o próprio nó, caso contrário, será
	 * retornado null.
	 * @param objeto é um produto.
	 * @return um produto ou null.
	 */
	public Produto pesquisar(Produto objeto) {
		if (objeto == null || vazio()) return null;
		No aux = consultar(objeto);
		if (aux == null) return null;
		return aux.dados;		
	}
	
	/**
	 * Verifica qual é o maior nó da
	 * árvore binária de busca.
	 * @param objeto um nó.
	 * @return um nó ou null.
	 */
	private No minimo(No objeto) {
		if (objeto == null || vazio()) return null;
		No aux = objeto;
		while (aux.esquerda != null) {
			aux = aux.esquerda;
		}
		return aux;
	}
	
	/**
	 * Verifica qual é o menor nó da
	 * árvore binária de busca.
	 * @param objeto um nó.
	 * @return um nó ou null.
	 */
	private No maximo(No objeto) {
		if (objeto == null || vazio()) return null;
		No aux = objeto;
		while (aux.direita != null) {
			aux = aux.direita;
		}
		return aux;
	}
	
	/**
	 * Retorna o antecessor do nó recebido 
	 * como parâmetro, ou um valor nulo.
	 * @param objeto um nó.
	 * @return um nó ou null.
	 */
	private No antecessor(No objeto) {
		if (objeto == null || vazio()) return null;
		if (objeto.esquerda != null) return maximo(objeto.esquerda);
		No anterior = objeto;
		No atual = objeto.pai;
		while (atual != null && anterior == atual.esquerda) {
			anterior = atual;
			atual = atual.pai;
		}
		return atual;
	}
	
	/**
	 * Retorna o sucessor do nó recebido 
	 * como parâmetro, ou um valor nulo.
	 * @param objeto um nó.
	 * @return um nó ou null.
	 */
	private No sucessor(No objeto) {
		if (objeto == null || vazio()) return null;
		if (objeto.direita != null) return minimo(objeto.direita);
		No anterior = objeto;
		No atual = objeto.pai;
		while (atual != null && anterior == atual.direita) {
			anterior = atual;
			atual = atual.pai;
		}
		return atual;
	}

	/**
	 * Visita a árvore binária de busca em 
	 * pós ordem, e armazena em um StrigBuffer.
	 * A visita pós-ordem é quando a raiz da
	 * sub-árvore é visitada depois de seus
	 * filhos a esquerda e a direita.
	 * @param no um nó.
	 * @param mensagen um StringBuffer.
	 */
	public void posOrdem(No no, StringBuffer mensagen) {
		if (vazio() || mensagen == null) {
			return;
		}
		if (no == null) {
			no = this.raiz;
		}
		if (no.esquerda != null) {
			posOrdem(no.esquerda, mensagen);
		}
		if (no.direita != null) {
			posOrdem(no.direita, mensagen); 
		}
		mensagen.append(no.dados + "\n");
	}

	/**
	 * Visita a árvore binária de busca em 
	 * pré-ordem, e armazena em um StrigBuffer.
	 * A visita pré-ordem é quando a raiz da
	 * sub-árvore é visitada antes de seus
	 * filhos a esquerda e a direita.
	 * @param no um nó.
	 * @param mensagen um StringBuffer.
	 */
	public void preOrdem(No no, StringBuffer mensagen) {
		if (vazio() || mensagen == null) {
			return;
		}
		if (no == null) {
			no = this.raiz;
		}
		mensagen.append(no.dados + "\n");
		if (no.esquerda != null) {
			preOrdem(no.esquerda, mensagen);
		}
		if (no.direita != null) {
			preOrdem(no.direita, mensagen);
		}
	}

	/**
	 * Visita a árvore binária de busca em 
	 * ordem, e armazena em um StrigBuffer.
	 * A visita em ordem é quando a raiz da
	 * sub-árvore é visitada depois do filho
	 * a esquerda, e antes do filho a direita.
	 * @param no um nó.
	 * @param mensagen um StringBuffer.
	 */
	public void emOrdem(No no, StringBuffer mensagen) {
		if (vazio() || mensagen == null) {
			return;
		}
		if (no == null) {
			no = this.raiz;
		}
		if (no.esquerda != null) {
			emOrdem(no.esquerda, mensagen);
		}
		mensagen.append(no.dados + "\n");
		if (no.direita != null) {
			emOrdem(no.direita, mensagen);
		}
	}

	/**
	 * Visita a árvore binária de busca em 
	 * nível, e armazena em um StrigBuffer.
	 * A visita pós-ordem é a visita de todos
	 * os nós de um nível da árvore, somente
	 * depois de visitar os nós do nível (n)
	 * que o nível (n + 1) será visitado.
	 * @param no um nó.
	 * @param mensagen um StringBuffer.
	 */
	public void emNivel(No no, StringBuffer mensagem) {
		if (vazio() || mensagem == null) {
			return;
		}
		if (no == null) {
			no = this.raiz;
		}
		Queue <No> fila = new LinkedList<>();
		fila.add(no);
		while (!fila.isEmpty()) {
			No node = fila.poll();
			if (node.esquerda != null) {
				fila.add(node.esquerda);
			}
			if (node.direita != null) {
				fila.add(node.direita);
			}
			mensagem.append(node.dados + "\n");
		} 
	}
}
