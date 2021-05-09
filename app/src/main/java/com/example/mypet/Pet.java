package com.example.mypet;

public class Pet {
    private String nombre;
    private String raza;
    private double peso;
    private String genero;

    public Pet(String nombre, String raza, double peso, String genero) {
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso= peso;
    }



    public String getGenero(){return genero;}

}
