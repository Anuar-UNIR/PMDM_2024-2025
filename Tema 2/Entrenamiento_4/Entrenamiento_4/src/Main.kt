//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Bienvenido a DamBank")

    // Solicitar datos para crear una nueva cuenta bancaria
    println("Introduce el IBAN de la cuenta (formato: dos letras y 22 números, por ejemplo, ES6621000418401234567891):")
    val iban = readLine().orEmpty()

    println("Introduce el titular de la cuenta:")
    val titular = readLine().orEmpty()

    try {
        // Crear una cuenta bancaria
        val cuentaBancaria = CuentaBancaria(iban, titular)
        println("Cuenta creada exitosamente.")

        var opcion: Int
        do {
            // Menú principal
            println(
                """
                Elige una opción:
                1. Ver datos de la cuenta
                2. Ver saldo
                3. Realizar un ingreso
                4. Realizar una retirada
                5. Ver movimientos
                6. Salir
                """.trimIndent()
            )
            opcion = readLine()?.toIntOrNull() ?: 0

            when (opcion) {
                1 -> println(cuentaBancaria.obtenerDatosCuenta())
                2 -> println(cuentaBancaria.obtenerSaldo())
                3 -> {
                    println("Introduce la cantidad a ingresar:")
                    val cantidad = readLine()?.toDoubleOrNull() ?: 0.0
                    cuentaBancaria.ingresarDinero(cantidad)
                }
                4 -> {
                    println("Introduce la cantidad a retirar:")
                    val cantidad = readLine()?.toDoubleOrNull() ?: 0.0
                    cuentaBancaria.retirarDinero(cantidad)
                }
                5 -> cuentaBancaria.mostrarMovimientos()
                6 -> println("Gracias por usar DamBank. ¡Hasta pronto!")
                else -> println("Opción no válida. Inténtalo de nuevo.")
            }
        } while (opcion != 6)

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}