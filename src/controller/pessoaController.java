package controller;

import java.util.HashMap;

import model.Contato;
import model.Pessoa;

public class PessoaController {
	
	public static String execute(HashMap<String, Pessoa> pessoas, String comando, String cpf, String nome, String endereco) {
		String message = "";
		switch(comando) {
			case "INSERT":
				pessoas.put(cpf, new Pessoa(cpf, nome, endereco));
				break;
			case "UPDATE":
				if (pessoas.get(cpf) != null) {
					pessoas.get(cpf).setNome(nome);
					pessoas.get(cpf).setEndereco(endereco);
					message = "Pessoa atualizada com sucesso";
				} else {
					message = "Pessoa não encontrada";
				}
				break;
			case "GET":
				if (!pessoas.isEmpty()) {
					if (pessoas.get(cpf) != null) {
						message = (pessoas.get(cpf).getCpf() + ";" + pessoas.get(cpf).getNome() + ";" + pessoas.get(cpf).getEndereco());
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
						pessoas.remove(cpf);
						message = "Pessoa removida com sucesso";
					} else {
						message = "Pessoa não encontrada";
					}
				} else {
					message = "Sem pessoas cadastradas";
				}
				break;
			case "LIST":
				if (!pessoas.isEmpty()) {
					message = String.valueOf(pessoas.size()) + "\n";
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
