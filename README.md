# Sistema de Gestión de Wallet

## Descripción

Este proyecto es una aplicación simple de gestión de Wallet que permite a los usuarios crear un cliente con su cuenta asociada y realizar operaciones bancarias básicas como consultar saldo, depositar fondos, retirar fondos, y convertir el saldo entre dólares y pesos chilenos.

## Características

- Creación de cuentas de clientes.
- Visualización de saldo.
- Depósito de fondos.
- Retiro de fondos.
- Conversión de moneda entre dólares y pesos chilenos.

## Tecnologías Utilizadas

- Java
- Interfaces para operaciones bancarias
-JUnit

## Presentación visual

![Captura de pantalla 2024-05-07 191923](https://github.com/RodStack/RodWallet/assets/57158158/54193a4b-5440-4c74-b3eb-b9edd0515d79)

![Captura de pantalla 2024-05-07 191855](https://github.com/RodStack/RodWallet/assets/57158158/2b8d08bb-8c14-4f55-a059-038392782c1a)

![Captura de pantalla 2024-05-07 191815](https://github.com/RodStack/RodWallet/assets/57158158/8bb5dbe9-cdaa-4b0c-a6d2-f04558bddfee)

## Pruebas de los metodos mas importantes
- **Clase Cuenta**:
  - depositar(double cantidad): Verifica que el saldo se incremente correctamente.
  - retirar(double cantidad): Asegura que el saldo se decremente o muestre un error de saldo insuficiente.
  - convertUSD() y convertCLP(): Pruebas para confirmar la correcta conversión de moneda.
