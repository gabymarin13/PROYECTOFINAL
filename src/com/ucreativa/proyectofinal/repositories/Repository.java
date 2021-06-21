package com.ucreativa.proyectofinal.repositories;

import com.ucreativa.proyectofinal.entities.Persona;
import java.util.List;

public interface Repository {

    void guardar(Persona persona, boolean esEmpleado);

    List<String> leerLista();
}
