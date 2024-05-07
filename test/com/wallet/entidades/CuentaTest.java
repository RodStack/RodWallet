package com.wallet.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CuentaTest {

    private Cuenta cuenta;

    @Before
    public void setUp() {
        cuenta = new Cuenta("Juan Perez", 1000);
    }

    @Test
    public void testDepositar() {
        cuenta.depositar(500);
        assertEquals(1500, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirar() {
        cuenta.retirar(300);
        assertEquals(700, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirarSaldoInsuficiente() {
        cuenta.retirar(1200);
        assertEquals(1000, cuenta.getSaldo(), 0.01); // Suponiendo que el saldo no cambia si no hay suficiente dinero
    }

    @Test
    public void testConvertUSD() {
        cuenta.convertUSD();
        assertEquals(1.25, cuenta.getSaldo(), 0.01);
        assertTrue(cuenta.isUSD());
    }

    @Test
    public void testConvertCLP() {
        cuenta.convertUSD(); // Primero convertimos a USD
        cuenta.convertCLP(); // Luego regresamos a CLP
        assertEquals(1000, cuenta.getSaldo(), 0.01);
        assertFalse(cuenta.isUSD());
    }

    @Test
    public void testGetCuentas() {
        List<Cuenta> cuentas = Cuenta.getCuentas();
        assertNotNull(cuentas);
        assertFalse(cuentas.isEmpty());
    }
}
