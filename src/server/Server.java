package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import controller.ContatoController;
import controller.PessoaController;
import model.Pessoa;

public class Server {

	public static HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(80);
		server.setReuseAddress(true);
		PessoaController controllerPessoa = new PessoaController();
		ContatoController controllerContato = new ContatoController();
		
		while (true) {
			System.out.println("Aguardado conexão...");
			try (Socket conn = server.accept();) {				
				
				System.out.println("Conectado com: "
						+ conn.getInetAddress().getHostAddress());
				
				InputStream in = conn.getInputStream();
				
				byte[] dadosBrutos = new byte[1024];
				int qtdBytesLidos = in.read(dadosBrutos);
				String dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
				String[] data = dadosStr.split(";");
				String result;
				if (data[0].equals("PESSOA")) {
					result = controllerPessoa.execute(pessoas, data[1], data[2], data[3], data[4]);	
				} else {
					result = controllerContato.execute(pessoas, data[1], data[2], data[3], Boolean.parseBoolean(data[4]));
				}
				
				System.out.println(result);
				
				OutputStream out = conn.getOutputStream();
				out.write(result.getBytes());
			}
		}

	}

}
