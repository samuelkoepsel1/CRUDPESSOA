package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Pessoa {

	public String cpf;

	public String nome;

	public String endereco;
	
	public HashMap<String, Contato> contato;

	public Pessoa(String cpf, String nome, String endereco) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = new HashMap<String, Contato>();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public HashMap<String, Contato> getContato() {
		return this.contato;
	}

	public void setContato(Contato contato) {
		this.contato.put(contato.getNumero(), contato);
	}

}
