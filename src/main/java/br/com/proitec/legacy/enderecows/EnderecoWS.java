package br.com.proitec.legacy.enderecows;

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
	private String localidade;
	private String uf;
	
	public EnderecoWS() {
		// TODO Auto-generated constructor stub
	}
	
	public EnderecoWS(Long identificador, String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
		super();
		this.identificador = identificador;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}
	
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
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return " CEP: " + this.cep + " - "+" LOGRADOURO: " + this.logradouro + " - "+" BAIRRO: " + this.bairro ;
	}
}