package controller;

import java.util.HashMap;

import model.Contato;
import model.Pessoa;

public class ContatoController {
	
	public static String execute(HashMap<String, Pessoa> pessoas, String comando, String cpf, String numero, boolean principal) {
		String message = "";
		switch(comando) {
			case "INSERT":
				if (pessoas.get(cpf) != null) {
					pessoas.get(cpf).setContato(new Contato(numero, principal));	
				} else {
					message = "Pessoa não encontrada";
				}
				break;
			case "UPDATE":
				if (pessoas.get(cpf) != null) {
					boolean find = false;
					String[] data = numero.split("/");
					if (pessoas.get(cpf).getContato().get(data[0]) != null) {
						pessoas.get(cpf).getContato().get(data[0]).setNumero(data[1]);
						pessoas.get(cpf).getContato().get(data[0]).setPrincipal(principal);
						message = "Contato atualizado com sucesso";
					} else {
						message = "Número não encontrado";	
					}
				} else {
					message = "Pessoa não encontrada";
				}
				break;
			case "GET":
				if (!pessoas.isEmpty()) {
					if (pessoas.get(cpf) != null) {
						message = (pessoas.get(cpf).getCpf() + ";" + pessoas.get(cpf).getNome() + ";" + pessoas.get(cpf).getEndereco() + ";");
						if (pessoas.get(cpf).getContato() == null) 
							message = "Sem contatos cadastrados";		
						for(String key : pessoas.get(cpf).getContato().keySet()) {
							if (pessoas.get(cpf).getContato().get(key).isPrincipal()) {
								message += "Contato princiapl: " + pessoas.get(cpf).getContato().get(key).getNumero() + ";";
							} else {
								message += pessoas.get(cpf).getContato().get(key).getNumero() + ";";	
							}
						}
					} else {
						message = "Pessoa não encontrada";
					}
				} else {
					message = "Sem pessoas cadastradas";
				}
				break;
			case "DELETE":
				if (pessoas != null) {
					if (pessoas.get(cpf) != null) {
						if (pessoas.get(cpf).getContato().get(numero) != null) {
							pessoas.get(cpf).getContato().remove(numero);
							message = "Contato removido com sucesso";	
						} else {
							message = "Número não encontrado";	
						}
					} else {
						message = "Pessoa não encontrada";
					}
				} else {
					message = "Sem pessoas cadastradas";
				}
				break;
			case "LIST":
				if (!pessoas.isEmpty()) {
					message = String.valueOf(pessoas.size());
					for (String key : pessoas.keySet()) {
						message += (pessoas.get(key).getCpf() + ";" + pessoas.get(key).getNome() + ";" + pessoas.get(key).getEndereco() + ";");
						if (pessoas.get(key).getContato() != null) {
							for(String chave : pessoas.get(key).getContato().keySet()) {
								if (pessoas.get(key).getContato().get(chave).isPrincipal()) {
									message += "Contato princiapl: " + pessoas.get(key).getContato().get(chave).getNumero() + ";";
								} else {
									message += pessoas.get(key).getContato().get(chave).getNumero() + ";";	
								}
							}
						}
						message += "\n";
					}
				} else {
					message = "Sem pessoas cadastradas";
				}
				break;
		}
		return message;
	}
}
