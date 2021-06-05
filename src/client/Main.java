package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Criando conexão!");
		try ( Socket conn = new Socket("4.tcp.ngrok.io", 15059);) {
			
			System.out.println("Conectado");
			InputStream in = conn.getInputStream();
			
			byte[] dadosBrutos = new byte[1024];
			int qtdBytesLidos = in.read(dadosBrutos);
			while (qtdBytesLidos >= 0) {
				String dadosStr = new String(dadosBrutos, 0, qtdBytesLidos);
				System.out.println(dadosStr);
				qtdBytesLidos = in.read(dadosBrutos);
			}
			
		} catch (UnknownHostException e) {
			System.out.println("Host não encontrado");
			e.printStackTrace();
		}

	}

}
