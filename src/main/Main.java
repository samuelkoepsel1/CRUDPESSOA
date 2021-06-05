package main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import controller.pessoaController;
import model.Pessoa;

public class Main {

	public static HashMap<String, Pessoa> pessoas;

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(90);
		server.setReuseAddress(true);
		
		while (true) {
			System.out.println("Aguardado conexão...");
			try (Socket conn = server.accept();) {
				
				System.out.println("Conectado com: "
						+ conn.getInetAddress().getHostAddress());
				
				OutputStream out = conn.getOutputStream();
				String msg = "Insira o comando desejado!";
				out.write(msg.getBytes());
				String comando = "LIST";
				String cpf = "00000000000";
				String nome = "teste";
				String endereco = "teste"; 
				pessoaController.execute(pessoas, comando, cpf, nome, endereco);
			}
		}

	}

}
