package br.biblioteca.main;
import javax.swing.JOptionPane;

import br.biblioteca.ArvoreBinariaDeBusca;
import br.biblioteca.Produto;
/**
 * Classe principal do projeto.
 * @author Rodrigo Silvestre.
 */
public class Main {
	public static void main(String[] args) {
		ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();
		StringBuffer visitaArvore = new StringBuffer();
		int op;
		String recebido;
		do {
			recebido = JOptionPane.showInputDialog(null, menu(), "Menu" ,1);
			while (!validação(recebido)) {
				JOptionPane.showMessageDialog(null, "// -  Entrada não númerica!   //", "Erro!", 0);
				recebido = JOptionPane.showInputDialog(null, menu(), "Menu" ,1);
			}
			op = Integer.parseInt(recebido);
			switch(op) {
				case 1: // Adicionar
					if (arvore.adicionar(criarProduto())) {
						JOptionPane.showMessageDialog(null, "// -  Sucesso na inserção!    //", "Sucesso!", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "// -  Insucesso na inserção!  //", "Insucesso!", 0);
					}
					break;
				case 2: // Remover
					Produto produto = arvore.remover(criarProduto());
					if (produto != null) {
						JOptionPane.showMessageDialog(null, "// -   Sucesso na remoção!    //\n" + produto, "Sucesso!", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "// -   Insucesso na remoção!  //", "Sucesso!", 1);
					}
					break;
				case 3: // Visita em Pós ordem
					arvore.posOrdem(null, visitaArvore);
					if (!visitaArvore.isEmpty()) {
						JOptionPane.showMessageDialog(null, "// -    Sucesso na visita!    //", "Sucesso!", 1);
						JOptionPane.showMessageDialog(null, visitaArvore, "Visita em pós ordem!", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "// -   Insucesso na visita!   //", "Insucesso!", 1);
					}
					visitaArvore.setLength(0);
					break;
				case 4: // Visita em Pré-ordem
					arvore.preOrdem(null, visitaArvore);
					if (!visitaArvore.isEmpty()) {
						JOptionPane.showMessageDialog(null, "// -    Sucesso na visita!    //", "Sucesso!", 1);
						JOptionPane.showMessageDialog(null, visitaArvore, "Visita em pré-ordem!", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "// -   Insucesso na visita!   //", "Insucesso!", 1);
					}
					visitaArvore.setLength(0);
					break;
				case 5:
					arvore.emOrdem(null, visitaArvore);
					if (!visitaArvore.isEmpty()) {
						JOptionPane.showMessageDialog(null, "// -    Sucesso na visita!    //", "Sucesso!", 1);
						JOptionPane.showMessageDialog(null, visitaArvore, "Visita em ordem!", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "// -   Insucesso na visita!   //", "Insucesso!", 1);
					}
					visitaArvore.setLength(0);
					break;
				case 6:
					arvore.emNivel(null, visitaArvore);
					if (!visitaArvore.isEmpty()) {
						JOptionPane.showMessageDialog(null, "// -    Sucesso na visita!    //", "Sucesso!", 1);
						JOptionPane.showMessageDialog(null, visitaArvore, "Visita em nível!", 1);
					}
					else {
						JOptionPane.showMessageDialog(null, "// -   Insucesso na visita!   //", "Insucesso!", 1);
					}
					visitaArvore.setLength(0);
					break;
				case 7:
					if (arvore.vazio()) {
						JOptionPane.showMessageDialog(null, "// -      Árvore vazia!       //", "Tamanho!", 2);
					}
					else {
						JOptionPane.showMessageDialog(null, "// - Quantidade de nós: " + arvore.length() + " //", "Tamanho!", 1);
					}
					break;
				case 8:
					JOptionPane.showMessageDialog(null, "// -     Encerrando......     //", "Sair!", 1);
					break;
				default:
					JOptionPane.showMessageDialog(null, "// -     Opação inválida!     //", "Sair!", 1);
					break;
			}
		} while(op != 8);
	}

	/**
	 * Retorna uma cadeia de carácteres (String)
	 * como formato do menu.
	 * @return uma String.
	 */
	public static String menu() {
		return "//==========//Menu//==========//\n// 1 -     Adicionar\n// 2 -      Remover\n// 3 -  Visita em Pós Ordem\n// 4 -  Visita em Pré-Ordem\n// 5 -   Visita em Ordem\n// 6 -   Visita em Nível\n// 7 -  Quantidade de nós\n// 8 -        Sair\n//==========//====//==========//\n// - Digite: ";
	}

	/**
	 * Cria um objeto do tipo Produto e
	 * o retorna.
	 * @return um Produto.
	 */
	public static Produto criarProduto() {
		Produto produto = new Produto();
		String dado;
		produto.setDescricao(JOptionPane.showInputDialog(null, "// - Digite o (nome/descrição) do produto: ", "Entrada de dados!", 1));
		dado = JOptionPane.showInputDialog(null, "// - Digite o preço do produto: ", "Entrada de dados!", 1);
		produto.setPreco(Double.parseDouble(dado));
		dado = JOptionPane.showInputDialog(null, "// - Digito a quantidade do produto: ", "Entrada de dados!", 1);
		while (!validação(dado)) {
			JOptionPane.showMessageDialog(null, "// -  Entrada não númerica!   //", "Erro!", 0);
			dado = JOptionPane.showInputDialog(null, "// - Digito a quantidade do produto: ", "Entrada de dados!", 1);
		}
		produto.setPreco(Integer.parseInt(dado));
		return produto;
	}

	/**
	 * Valida a entrada de dados númerica,
	 * retornando verdadeiro caso seja um número,
	 * e falso caso contrário.
	 * @param num uma String.
	 * @return verdadeiro ou falso.
	 */
	public static boolean validação(String num) {
		int tam = num.length();
		for (int i = 0; i < tam; i++) {
			if (!Character.isDigit(num.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
