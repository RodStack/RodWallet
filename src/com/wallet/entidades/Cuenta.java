package com.wallet.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.wallet.interfaces.Depositar;
import com.wallet.interfaces.Retirar;

/**
 * La clase Cuenta gestiona la información financiera de un cliente, permitiendo operaciones
 * como depósitos y retiros, así como la conversión entre monedas.
 */
public class Cuenta implements Depositar, Retirar {
    public static final double USD_CLP = 800;
    public static final double CLP_USD = 0.00125;
    private static List<Cuenta> cuentas = new ArrayList<>();
    private static int IdNumeroCuenta = 1; // Contador para el número de cuenta
    
    private int numeroCuenta;
    private String titular;
    private double saldo;
    private boolean USD;
    
    /**
     * Constructor que inicializa una nueva cuenta con un titular y un saldo inicial.
     * @param El nombre del titular de la cuenta.
     * @param El saldo inicial de la cuenta.
     */
    public Cuenta(String titular, double saldo) {
        this.numeroCuenta = IdNumeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.USD = false;
        cuentas.add(this);
        IdNumeroCuenta++;
    }
    
    /**
     * Crea una nueva cuenta a partir de datos ingresados por el usuario.
     * @param scan Scanner para leer la entrada del usuario.
     * @return Retorna la nueva cuenta creada.
     */
    public static Cuenta crearCuenta(Scanner scan) {
        System.out.println("Ingrese nombre del titular: ");
        String titular = scan.nextLine();

        System.out.println("Ingrese saldo inicial: ");
        double saldo = scan.nextDouble();
        scan.nextLine(); // Limpiar buffer después de leer un número

        return new Cuenta(titular, saldo);
    }
    
    /**
     * Muestra información de la cuenta incluyendo número, titular y saldo.
     */
    public void mostrarInfo() {
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Nombre del titular: " + titular);
        System.out.println("El saldo es: " + saldo + (USD ? " dolares" : " pesos"));
    }
    
    /**
     * Devuelve una lista de todas las cuentas creadas.
     * @return Lista de cuentas.
     */
    public static List<Cuenta> getCuentas() {
        return cuentas;
    }
    
    /**
     * Permite el retiro de una cantidad especificada de la cuenta si el saldo es suficiente.
     * @param La cantidad a retirar.
     */
    @Override
    public void retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Se han retirado " + cantidad + (USD ? " dolares" : " pesos") + " de tu cuenta");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    
    /**
     * Deposita una cantidad especificada a la cuenta.
     * @param La cantidad a depositar.
     */
    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Se han depositado " + cantidad + (USD ? " dolares" : " pesos") + " en tu cuenta");
    }
    
    /**
     * Convierte el saldo de la cuenta a dólares estadounidenses si no está ya en esta moneda.
     */
    public void convertUSD() {
        if (!USD) {
            saldo = saldo / USD_CLP;
            USD = true;
            System.out.println("Tu saldo es $" + saldo + " dolares");
        } else {
            System.out.println("Tu cuenta ya esta en dolares");
        }
    }
    
    /**
     * Convierte el saldo de la cuenta a pesos chilenos si no está ya en esta moneda.
     */
    public void convertCLP() {
        if (USD) {
            saldo = saldo * USD_CLP;
            USD = false;
            System.out.println("Tu saldo es $" + saldo + " pesos");
        } else {
            System.out.println("Tu cuenta ya esta en pesos");
        }
    }

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public boolean isUSD() {
		return USD;
	}

	public void setUSD(boolean uSD) {
		USD = uSD;
	}
	
	
    
}
