package com.ucreativa.proyectofinal.entities;

public class Empleado extends Persona{

    private String codigo;
    private String puesto;

    public Empleado(String nombre, String apellido, String cedula, String telefono, int edad, String codigo, String puesto) {
        super(nombre, apellido, cedula, telefono, edad);
        this.codigo = codigo;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return this.codigo + this.puesto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
