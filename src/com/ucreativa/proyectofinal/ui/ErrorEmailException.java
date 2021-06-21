package com.ucreativa.proyectofinal.ui;

public class ErrorEmailException extends Exception{

    public ErrorEmailException(){
        super("El correo proporcionado no cumple con un formato válido");
    }
}
