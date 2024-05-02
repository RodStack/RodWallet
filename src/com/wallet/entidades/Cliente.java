package com.wallet.entidades;

import java.util.Scanner;

public class Cliente {

    private long id;
    private String nombre;
    private Cuenta cuenta;
    
    /**
     * Constructor para crear un nuevo cliente.
     *
     * @param El ID único del cliente.
     * @param El nombre del cliente.
     * @param La cuenta asociada al cliente.
     */
    public Cliente(long id, String nombre, Cuenta cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.cuenta = cuenta;
    }
    
    /**
     * Método estático para crear un cliente a partir de los datos proporcionados por el usuario.
     * Utiliza un objeto Scanner para leer los datos.
     *
     * @param scanner El Scanner para leer los datos del usuario.
     * @return Retorna un nuevo objeto Cliente creado con los datos introducidos.
     */
    public static Cliente crearCliente(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Limpia el buffer después de leer un número

        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        Cuenta nuevaCuenta = Cuenta.crearCuenta(scanner); // Llama al método para crear una cuenta

        return new Cliente(id, nombre, nuevaCuenta);
    }
    
    /**
     * Muestra la información del cliente, incluyendo los detalles de su cuenta.
     */
    public void mostrarInfo() {
        System.out.println("Id cliente: " + id);
        System.out.println("Nombre cliente: " + nombre);
        cuenta.mostrarInfo();
    }

    // Getters y setters 
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
