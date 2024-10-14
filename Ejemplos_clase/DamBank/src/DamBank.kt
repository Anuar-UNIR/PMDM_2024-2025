//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Bienvenido a DamBank")

    println("Introduzca el IBAN de la cuenta bancaria (formato: dos letras y 22 digitos)")
    val iban = readLine().orEmpty()

    println("Introduzca el titular dela cuenta")
    val  titular = readLine().orEmpty()

    try {
        val cuentaBancaria = CuentaBancaria(iban, titular)
        println("Cuenta creada satisfacoriamente")

        var opcion: Int

        do{
            println("""
                Elige una opción:
                1. Ver datos de la cuenta
                2. Ver saldo
                3. Realizar un ingreso
                4. Realizar una retirada
                5. Ver movimientos
                6. Salir
                """.trimIndent())

            opcion = readLine()?.toIntOrNull() ?: 0

            when(opcion) {
                1 -> println(cuentaBancaria.obtenerDatosCuentaBancaria())
                2 -> println(cuentaBancaria.obtenerSaldo())
                3 -> {
                    println("Introduzca la cantidad a ingresar")
                    val cantidad = readLine()?.toDoubleOrNull() ?: 0.0
                    cuentaBancaria.ingresarDinero(cantidad)
                }
                4 -> {
                    println("Introduzca la cantidad a dinero")
                    val cantidad = readLine()?.toDoubleOrNull() ?: 0.0
                    cuentaBancaria.retirarDinero(cantidad)
                }
                5 -> cuentaBancaria.mostrarMovimientos()
                6 -> println("Gracias por usar DamBank. Sayonara !!!")
                else -> println("Opcion no valida. Intentelo de nuevo")
            }
        }while(opcion != 6)

    }catch (e: IllegalArgumentException){
        println(e.message)
    }
}