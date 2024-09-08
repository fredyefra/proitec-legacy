package br.com.proitec.legacy.model;

import java.io.Serializable;

public class FipeVeiculoWS implements Serializable {

    private static final long serialVersionUID = 1L;
    private String code;
    private String name;

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



