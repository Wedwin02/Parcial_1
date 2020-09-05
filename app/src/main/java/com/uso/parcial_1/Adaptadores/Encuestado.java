package com.uso.parcial_1.Adaptadores;

import android.widget.TextView;

public class Encuestado {
    private String Nombre;
    private String Edad;
    private String Alimento;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getAlimento() {
        return Alimento;
    }

    public void setAlimento(String alimento) {
        Alimento = alimento;
    }
}
