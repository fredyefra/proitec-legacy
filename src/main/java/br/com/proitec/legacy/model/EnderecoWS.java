package br.com.proitec.legacy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EnderecoWS implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long identificador;
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	
	
	public EnderecoWS() {
		// TODO Auto-generated constructor stub
	}
	
	public EnderecoWS(Long identificador, String cep, String logradouro, String complemento, String bairro) {
		this.identificador = identificador;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	
	//@NotNull (message = "Campo obrigatório!1")
	//@NotEmpty(message = "Campo obrigatório!2")
	//@NotBlank (message = "Campo obrigatório!3")
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	//@NotBlank (message = "Campo obrigatório!")
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@Override
	public String toString() {
		return " CEP: " + this.cep + " - "+" LOGRADOURO: " + this.logradouro + this.complemento +  " - "+"  BAIRRO: " + this.bairro ;
	}
}