package br.com.proitec.legacy.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.AbstractPersistable;

import br.com.proitec.legacy.enderecows.EnderecoWS;

@Entity
public class Cliente extends AbstractPersistable<Long> implements Serializable    {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identificador;
	private String nome;
	private String telefone;
    private String email;
    private EnderecoWS endereco;
    
	private LocalDate dtCadastro;

	public Cliente() {

	}

	public Cliente(Long identificador, String nome,  String telefone, String email, EnderecoWS endereco) {
		this.identificador = identificador;
		this.nome = nome;
		this.telefone = telefone;
	    this.email = email;
	    this.endereco = endereco;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdentificador() {return identificador;}
	public void setIdentificador(Long identificador) {this.identificador = identificador;}
   
	@Length(min = 3, max = 30, message = "Digite entre 3 e 30 letras.")
	@NotBlank (message = "Campo obrigatório!")
	@Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Digite somente letras.")
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}


	@NotBlank (message = "Campo obrigatório!")
	public String getTelefone() {return telefone;}
	public void setTelefone(String telefone) {this.telefone = telefone;}

	public LocalDate getDtCadastro() {return dtCadastro;}
	public void setDtCadastro(LocalDate dtCadastro) {this.dtCadastro = dtCadastro;}

	@Email(message = "Formato de email inválido!")
	@NotBlank (message = "Campo obrigatório!")
	public String getEmail() {	return email;}
	public void setEmail(String email) {this.email = email;}
	
	//@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER) 
	//@JoinTable(
		//	name="CLIENTE_ENDERECO",
		//	joinColumns=
		//	@JoinColumn(name="cliente_fk", referencedColumnName="identificador"),
		//	inverseJoinColumns=
		//	@JoinColumn(name="endereco_fk", referencedColumnName="identificador")
	//)
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER) 
	@JoinColumn(name = "ENDERECO_FK")
	public  EnderecoWS getEndereco() {return endereco;}
	public void setEndereco(EnderecoWS endereco) {this.endereco = endereco;}
	
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
		Cliente other = (Cliente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		return "Identificador --> " + this.identificador + "Nome --> " + this.nome; 
	}
}