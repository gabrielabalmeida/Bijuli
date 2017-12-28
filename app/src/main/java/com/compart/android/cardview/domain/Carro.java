package com.compart.android.cardview.domain;

/**
 * Created by gabriela.almeida on 16/11/2017.
 */

public class Carro { private String modelo;
    private String marca;
    private int foto;

    public Carro(String m, String b, int p){
        modelo = m;
        marca = b;
        foto = p;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
