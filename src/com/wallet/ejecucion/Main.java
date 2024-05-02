package com.wallet.ejecucion;

import com.wallet.entidades.Cliente;
import java.util.Scanner;

/**
 * Clase principal que ejecuta la aplicación de gestión de Wallet.
 * Permite al usuario crear un cliente con su cuenta y realizar diversas operaciones bancarias.
 */
public class Main {

    /**
     * Punto de entrada principal del programa. 
     * Gestiona la creación de un cliente y permite realizar operaciones como ver saldo, 
     * depositar fondos, retirar fondos, y convertir saldos entre dólares y pesos chilenos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = null;

        // Proceso de creación inicial del cliente
        System.out.println("Bienvenido al sistema de gestión de Wallet.");
        System.out.println("Primero, creemos un nuevo cliente y su cuenta asociada.");
        cliente = Cliente.crearCliente(scanner);

        // Asegurar que el cliente ha sido creado antes de continuar
        if (cliente == null) {
            System.out.println("Hubo un error creando el cliente. El programa terminará.");
            return;
        }

        int opcion;
        do {
            System.out.println("\nPor favor, elija una opción:");
            System.out.println("1. Ver Saldo");
            System.out.println("2. Depositar Fondos");
            System.out.println("3. Retirar Fondos");
            System.out.println("4. Convertir a Dólares");
            System.out.println("5. Convertir a Pesos CLP");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cliente.mostrarInfo();
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    cliente.getCuenta().depositar(montoDeposito);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double montoRetiro = scanner.nextDouble();
                    cliente.getCuenta().retirar(montoRetiro);
                    break;
                case 4:
                    cliente.getCuenta().convertUSD();
                    break;
                case 5:
                    cliente.getCuenta().convertCLP();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor intente nuevamente.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
