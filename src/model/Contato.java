package model;

public class Contato {
	
	public boolean principal;
	
	public String numero;

	public Contato(String numero, boolean principal) {
		super();
		this.numero = numero;
		this.principal = principal;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
