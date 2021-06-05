package controller;

import java.util.HashMap;

import model.Pessoa;

public class pessoaController {
	
	public static void execute(HashMap<String, Pessoa> pessoas, String comando, String cpf, String nome, String endereco) {
		switch(comando) {
			case "INSERT":
				pessoas.put(cpf, new Pessoa(cpf, nome, endereco));
				break;
			case "UPDATE":
				if (pessoas.get(cpf) != null) {
					pessoas.get(cpf).setNome(nome);
					pessoas.get(cpf).setEndereco(endereco);
					System.out.println("Pessoa atualizada com sucesso");
				} else {
					System.out.println("Pessoa não encontrada");
				}
				break;
			case "GET":
				if (pessoas != null) {
					if (pessoas.get(cpf) != null) {
						System.out.println(pessoas.get(cpf).getCpf() + ";" + pessoas.get(cpf).getNome() + ";" + pessoas.get(cpf).getEndereco());
					} else {
						System.out.println("Pessoa não encontrada");
					}
				} else {
					System.out.println("Sem pessoas cadastradas");
				}
				break;
			case "DELETE":
				if (pessoas != null) {
					if (pessoas.get(cpf) != null) {
						pessoas.remove(cpf);
						System.out.println("Pessoa removida com sucesso");
					} else {
						System.out.println("Pessoa não encontrada");
					}
				} else {
					System.out.println("Sem pessoas cadastradas");
				}
				break;
			case "LIST":
				if (pessoas != null) {
					pessoas.forEach((key, value) -> {
						System.out.println(value.getCpf() + ";" + value.getNome() + ";" + value.getEndereco());
					});
				} else {
					System.out.println("Sem pessoas cadastradas");
				}
				break;
		}
	}
}
