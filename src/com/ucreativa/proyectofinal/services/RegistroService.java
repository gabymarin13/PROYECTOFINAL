package com.ucreativa.proyectofinal.services;

import com.ucreativa.proyectofinal.entities.Cliente;
import com.ucreativa.proyectofinal.entities.Empleado;
import com.ucreativa.proyectofinal.entities.Persona;
import com.ucreativa.proyectofinal.repositories.Repository;
import com.ucreativa.proyectofinal.ui.ErrorEdadException;

import java.util.List;

public class RegistroService {

    private Repository repository;

    public RegistroService(Repository repository){
        this.repository = repository;
    }

    public void guardar(String nombre, String apellido, String cedula, String telefono, String edadRecibida, String correo,
                        String codigo, String puesto, boolean esEmpleado) throws ErrorEdadException {

        int edad;
        try{
            edad = Integer.parseInt(edadRecibida);
        }catch (NumberFormatException x){
            throw new ErrorEdadException(edadRecibida);
        }
        Persona persona;
        if(esEmpleado){
            persona = new Empleado(nombre, apellido, cedula,telefono, edad, codigo, puesto);
        } else {
            persona = new Cliente(nombre, apellido, cedula, telefono, edad, correo);
        }
        this.repository.guardar(persona, esEmpleado);
    }


    public List<String> leerLista(){
        return this.repository.leerLista();
    }
}
