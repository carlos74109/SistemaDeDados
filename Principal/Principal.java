package Principal;

import java.util.Scanner;

import Banco_Dados.Crud;


public class Principal {

	public static void main(String[] args) {
		
		String continuar = "sim";
		Scanner entradaCon = new Scanner(System.in);
		Scanner entrada = new Scanner(System.in);
		Scanner entradaNome = new Scanner(System.in);
		Scanner entradaIdade = new Scanner(System.in);
		Scanner entradaProfisao = new Scanner(System.in);
		Scanner entradaId = new Scanner(System.in);
		Scanner entradaNomeEditado = new Scanner(System.in);
		Scanner entradaIdadeEditado = new Scanner(System.in);
		Scanner entradaEditarProfissao = new Scanner(System.in);
		
		Crud bancoDados = new Crud();
		while(continuar.equalsIgnoreCase("sim")) {
			
			System.out.println("1 para caso queria fazer uma inserção de dados");
			System.out.println("2 para visualizar os dados do Banco de dados");
			System.out.println("3 para fazer uma edição no banco de dados");
			System.out.println("4 para fazer a exclusão no banco de dados");
			System.out.println("5 para fazer a visualização de dados no bloco de notas");
			
			
			int numeroEscolha = entrada.nextInt();
			
			if(numeroEscolha == 1) {
				System.out.println("Digite seu nome: ");
				String nome = entradaNome.next();
				
				System.out.println("Digite sua idade: ");
				String idade = entradaIdade.next();
				
				System.out.println("Digite sua profissão: ");
				String profissao = entradaProfisao.nextLine();
				
				bancoDados.inserirDados(nome, idade, profissao);
				/*entradaNome.close();
				entradaIdade.close();
				entradaProfisao.close();*/
				
			}if (numeroEscolha == 2) {
				bancoDados.buscarDado();
				
			}if(numeroEscolha == 3) {
				bancoDados.buscarDado();
				System.out.println("Escolha qual dado vc quer  editar a parte do Id");
				int id = entradaId.nextInt();
				
				System.out.println("Digite seu novo nome: ");
				String nomeEditado = entradaNomeEditado.next();
				
				System.out.println("Digite sua nova idade: ");
				String idade = entradaIdadeEditado.next();
				
				System.out.println("Digite sua nova Profissão");
				String profissao = entradaEditarProfissao.next();
				
				bancoDados.editarDados(nomeEditado, idade, profissao, id);
				bancoDados.buscarDado();
				
				
			}if (numeroEscolha == 4) {
				bancoDados.buscarDado();
				System.out.println("Digite o numero do Id que vocer quer excluir");
				int id = entradaId.nextInt();
				bancoDados.excluirDado(id);
				bancoDados.buscarDado();
				System.out.println("Dado excluido");
				
			}if(numeroEscolha == 5) {
				bancoDados.buscarDadoTxt();
			}
			System.out.println("Deseja continuar? ");
			
			continuar = entradaCon.next();
			
			
			//entrada.close();
		}
		
		System.out.println("Aplicação encerrada");
		entradaNome.close();
		entradaIdade.close();
		entradaProfisao.close();
		entradaId.close();
		entradaCon.close();
		entradaId.close();
		entradaIdadeEditado.close();
		entradaNomeEditado.close();
		entradaEditarProfissao.close();
		entrada.close();
		
		
	}			

}
