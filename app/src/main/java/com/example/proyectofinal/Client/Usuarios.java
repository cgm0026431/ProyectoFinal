package com.example.proyectofinal.Client;

public class Usuarios {
    private String nombre;
    private String mes;
    private  int anio;
    private  int id;

    public  Usuarios(){

    }
    public  Usuarios(String nombre,String mes,int anio, int id){
        this.nombre=nombre;
        this.mes=mes;
        this.anio=anio;
        this.id=id;
    }
    public  Usuarios(String nombre,String mes,int anio){
        this.nombre=nombre;
        this.mes=mes;
        this.anio=anio;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
