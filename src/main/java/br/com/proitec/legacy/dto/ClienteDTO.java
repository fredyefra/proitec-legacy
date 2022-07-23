package br.com.proitec.legacy.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ClienteDTO implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String endereco;
	private String telefone;
    private String email;
	
	private LocalDate dtCadastro;

	public ClienteDTO() {

	}

	public ClienteDTO(String nome, String endereco, String telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	    this.email = email;
	}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getEndereco() {return endereco;}
	public void setEndereco(String endereco) {this.endereco = endereco;}

	public String getTelefone() {return telefone;}
	public void setTelefone(String telefone) {this.telefone = telefone;}

	public LocalDate getDtCadastro() {return dtCadastro;}
	public void setDtCadastro(LocalDate dtCadastro) {this.dtCadastro = dtCadastro;}

	public String getEmail() {	return email;}
	public void setEmail(String email) {this.email = email;}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}