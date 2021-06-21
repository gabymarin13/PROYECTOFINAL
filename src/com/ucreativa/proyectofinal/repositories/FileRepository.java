package com.ucreativa.proyectofinal.repositories;

import com.ucreativa.proyectofinal.entities.Persona;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepository implements Repository{

    private final String archivo = "Registro.txt";

    @Override
    public void guardar(Persona persona, boolean esEmpleado) {

        String texto;
        if(esEmpleado){
            texto = "Empleado: " + persona.getNombre() + " " + persona.getApellido() + " " +
                    "- Céd: " + persona.getCedula() + " - " + persona.getTelefono() + "\n\n";
        } else {
            texto = "Cliente: " + persona.getNombre() + " " + persona.getApellido() + " " +
                "- Céd: " + persona.getCedula() + " - " + persona.getTelefono() + "\n\n";
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
            writer.append(texto);
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<String> leerLista() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            return reader.lines().collect(Collectors.toList());
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

}
