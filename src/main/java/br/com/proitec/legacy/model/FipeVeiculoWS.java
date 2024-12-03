package br.com.proitec.legacy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class FipeVeiculoWS implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long identificador;
    private String type;
    private String code;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FipeVeiculoWS{" +
                "CODIGO ='" + code + '\'' +
                ", NOME ='" + name + '\'' +
                '}';
    }
}



