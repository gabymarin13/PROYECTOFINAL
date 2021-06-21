package com.ucreativa.proyectofinal.ui;

public class ErrorEdadException extends Exception {

    public ErrorEdadException(String edad){
        super("El dato " + edad + " no coincide con el formato permitido. \n \nSolo se permiten números enteros. ");
    }
}
