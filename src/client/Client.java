package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;

import controller.ConexaoCliente;
import controller.PessoaController;
import model.Pessoa;

public class Client {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Criando conexão!");
		
		boolean keep = true;
		ConexaoCliente cliente = new ConexaoCliente();
		String message = "";
		while (keep) {
			Scanner data = new Scanner(System.in);
			System.out.println("Bem vindo ao gereciamento de contatos de pessoas!");
			System.out.println("Para gerenciar pessoas digite 1 e para gerenciar contatos digite 2.");
			int process = data.nextInt();
			if (process  == 1) {
				System.out.println("Para incluir uma pessoa digite 1; \n" +
						"Para alterar os dados de uma pessoa digite 2; \n" +
						"Para buscar os dados de uma pessoa digite 3; \n" +
						"Para excluir uma pessoa digite 4; \n" +
						"Para listar todas as pessoas digite 5.");
				String cpf;
				String nome;
				String endereco;
				int command = data.nextInt();
				switch (command) {
					case 1:
						data.nextLine();
						System.out.println("Digite o cpf da pessoa.");
						cpf = data.nextLine();
						System.out.println("Digite o nome da pessoa.");
						nome = data.nextLine();
						System.out.println("Digite o endereço da pessoa.");
						endereco = data.nextLine();
						message = "PESSOA;INSERT;"+cpf+";"+nome+";"+endereco+";";
						break;
					case 2:
						data.nextLine();
						System.out.println("Digite o cpf da pessoa que deseja alterar.");
						cpf = data.nextLine();
						System.out.println("Digite o nome da pessoa.");
						nome = data.nextLine();
						System.out.println("Digite o endereço da pessoa.");
						endereco = data.nextLine();
						message = "PESSOA;UPDATE;"+cpf+";"+nome+";"+endereco+";";
						break;
					case 3:
						data.nextLine();
						System.out.println("Digite o cpf da pessoa que deseja buscar.");
						cpf = data.nextLine();
						nome = " ";
						endereco = " ";
						message = "PESSOA;GET;"+cpf+";"+nome+";"+endereco+";";
						break;
					case 4:
						data.nextLine();
						System.out.println("Digite o cpf da pessoa que deseja excluir.");
						cpf = data.nextLine();
						nome = " ";
						endereco = " ";
						message = "PESSOA;DELETE;"+cpf+";"+nome+";"+endereco+";";
						break;
					case 5:
						data.nextLine();
						cpf = "0";
						nome = " ";
						endereco = " ";
						message = "PESSOA;LIST;"+cpf+";"+nome+";"+endereco+";";
						break;
				}
			} else {System.out.println("Para incluir um contato digite 1; \n" +
					"Para alterar o contato de uma pessoa digite 2; \n" +
					"Para buscar os contatos de uma pessoa digite 3; \n" +
					"Para excluir o contato de uma pessoa digite 4; \n" +
					"Para listar todos os contatos digite 5.");
			String cpf;
			String numero;
			boolean principal;
			int command = data.nextInt();
			switch (command) {
				case 1:
					data.nextLine();
					System.out.println("Digite o cpf da pessoa.");
					cpf = data.nextLine();
					System.out.println("Digite o número de contato.");
					numero = data.nextLine();
					System.out.println("Se for o contato principal digite 1, caso contrário digite 0.");
					principal = data.nextLine().equals("1") ? true : false;
					message = "CONTATO;INSERT;"+cpf+";"+numero+";"+principal+";";
					break;
				case 2:
					data.nextLine();
					System.out.println("Digite o cpf da pessoa que deseja alterar.");
					cpf = data.nextLine();
					System.out.println("Digite o antigo número que deseja alterar.");
					numero = data.nextLine();
					System.out.println("Digite o novo número de contato.");
					numero += "/"+data.nextLine();
					System.out.println("Se for o contato principal digite 1, caso contrário digite 0.");
					principal = data.nextLine().equals("1") ? true : false;
					message = "CONTATO;UPDATE;"+cpf+";"+numero+";"+principal+";";
					break;
				case 3:
					data.nextLine();
					System.out.println("Digite o cpf da pessoa que deseja buscar.");
					cpf = data.nextLine();
					numero = " ";
					principal = false;
					message = "CONTATO;GET;"+cpf+";"+numero+";"+principal+";";
					break;
				case 4:
					data.nextLine();
					System.out.println("Digite o cpf da pessoa que deseja excluir o contato.");
					cpf = data.nextLine();
					System.out.println("Digite o  número de contato a ser excluído.");
					numero = data.nextLine();
					principal = false;
					message = "CONTATO;DELETE;"+cpf+";"+numero+";"+principal+";";
					break;
				case 5:
					data.nextLine();
					cpf = "0";
					numero = " ";
					principal = false;
					message = "CONTATO;LIST;"+cpf+";"+numero+";"+principal+";";
					break;
			}
			}
			cliente.sendData(message);
		}
	}

}
