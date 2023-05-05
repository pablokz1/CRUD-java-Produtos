package ArmazemTemDeTudo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		//Variável de operação
		int op = 10;
		
		//Lista para armazenar os dados 
		ArrayList<Produtos> produtos = new ArrayList();
		
		//Cadastrando produtos
		Produtos Lapis = new Produtos(1005, "Lapis", 15000, 55.00, "Bic", "Sem Garantia");
		produtos.add(Lapis);
		Produtos Notebook = new Produtos(1004, "Notebook", 1000, 2500.00, "Samsung", "1 ano");
		produtos.add(Notebook);
		Produtos TV = new Produtos(1003, "TV", 1500, 3000.00, "Samsung", "1 ano");
		produtos.add(TV);
		Produtos Controle = new Produtos(1002, "Controle", 1500, 25.00, "Samsung", "1 ano");
		produtos.add(Controle);
		Produtos PS4 = new Produtos(1001, "PS4", 1000, 2500.00, "PlayStation", "1 ano");
		produtos.add(PS4);
		Produtos PS5 = new Produtos(1000, "PS5", 1000, 4500.00, "PlayStation", "1 ano");
		produtos.add(PS5);
		Produtos Alexia = new Produtos(1006, "Alexia", 10500, 300.00, "Amazon", "1 ano");
		produtos.add(Alexia);
		
			
			/*Estrutura de controle que permite que o código seja executado repetidamente com base em 
			uma determinada condição booleana*/
			while (op != 0) {
			Scanner scan = new Scanner(System.in);
			//Interface com o usu rio 
			System.out.println("|=======================================|");
			System.out.println("|Menu:                                  |");
			System.out.println("|Digite 1 para Cadastrar um produto        |");
			System.out.println("|Digite 2 para Pesquisar produto(s)     |");
			System.out.println("|Digite 3 para Listar todos os produtos |");
			System.out.println("|Digite 4 para Listar produtos pelo preço|");
			System.out.println("|Digite 5 para Remover produto pelo nome|");
			System.out.println("|Digite 6 para Editar o mome do produto |");
			System.out.println("|Digite 0 para Sair                     |");
			System.out.println("|=======================================|");
			op = scan.nextInt();
			//Estrutura de condição que define o código a ser executado com base em uma comparação de valores
			switch(op) {
			
			case 1://Criando um novo objeto
					System.out.print("Digite o id do produto: ");
					int id = scan.nextInt();
					System.out.print("Digite o nome do produto: ");
					String nome = scan.next();
					System.out.print("Quantos produtos tem em estoque: ");
					int qtdeEstoque = scan.nextInt();
					System.out.print("Digite o pre o do produto: ");
					double preco = scan.nextDouble();
					System.out.print("Digite a marca do produto: ");
					String marca = scan.next();
					System.out.print("Digite a garantia do produto: ");
					String garantia = scan.next();
					Produtos p = new Produtos(id, nome, qtdeEstoque, preco, marca, garantia);
					produtos.add(p);
				break;
				
			case 2://Pesquisando um objeto a partir de um atributo
				System.out.print("Digite o nome do produto: ");
				String nomeAchado = scan.next();
				
				for(Produtos produto: produtos) {
					if(produto.getNome().equalsIgnoreCase(nomeAchado)) {
						System.out.println(produto.toString());
					}
				}
				break;
				
			case 3://Listar todos os produtos 
				produtos.stream().
				forEach(v -> System.out.println(v.toString()));
				break;
				
			case 4://Listar produtos de forma ordenada a partir de um atributo
				System.out.print("Digite o valor do produto: ");
				double valorAchado = scan.nextInt();
				produtos.stream()
				.filter(v -> v.getPreco() < valorAchado)
				.sorted(Comparator.comparing(Produtos::getPreco))
				.forEach(System.out::println);
				break;
				
			case 5://Remover produto
				System.out.print("Digite o id do produto: ");
				int produtoExcluido = scan.nextInt();

				Produtos produtoEncontrado = produtos.stream()
						.filter(p1 -> p1.getId() == produtoExcluido)
						.findFirst().orElse(null);
				if (produtoEncontrado != null) {
					System.out.println("Produto encontrado, deseja remover o produto ? s/n");
					String sn = scan.next().toLowerCase();
					if(sn.equalsIgnoreCase("s"))  {
						produtos.remove(produtoEncontrado);
						System.out.printf("O produto de id: %s, foi  removido com sucesso!\r\n",
								produtoEncontrado.getNome());
					}else {
						System.out.printf("Produto de id: %s, não removido!\r\n",produtoExcluido );
					}
				} else {
					System.out.printf("Produto de ID: %s não foi encontrado!\r\n", produtoExcluido);
				}
				break;
				
			case 6://Editar um atributo do objeto
				System.out.print("Digite o id do produto: ");
				int modificar = scan.nextInt();

				Produtos produtoLocalizado = produtos.stream()
						.filter(p1 -> p1.getId() == modificar)
						.findFirst().orElse(null);
				if (produtoLocalizado != null) {
							System.out.print("Digite o nome para qual quer alterar: ");
							String nomeModificado = scan.next();
							produtoLocalizado.setNome(nomeModificado);
							System.out.printf("Nome do produto de id %s, alterado com sucesso!\r\n", modificar );
							

				}else {
					System.out.printf("Produto de ID: %s não foi encontrado!\r\n", modificar);
				}
				break;
				
			case 0://Sair da aplicação
				System.out.println("Saiu!");
				System.exit(0);
				break;
			default:
				scan.close();	
				break;
			}
		  }

		}
}



