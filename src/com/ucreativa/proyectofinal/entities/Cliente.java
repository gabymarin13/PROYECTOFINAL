package com.ucreativa.proyectofinal.entities;

public class Cliente extends Persona{

    private String correo;

    public Cliente(String nombre, String apellido, String cedula, String telefono, int edad, String correo) {
        super(nombre, apellido, cedula, telefono, edad);
        this.correo = correo;
    }


    @Override
    public String toString() {
        return this.correo;
    }


    public String getCorreo() {
        return correo;
    }
}
