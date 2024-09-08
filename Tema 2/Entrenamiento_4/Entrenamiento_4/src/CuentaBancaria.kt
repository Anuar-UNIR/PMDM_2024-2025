class CuentaBancaria(val iban: String, val titular: String) {
    private var saldo: Double = 0.0
    private val movimientos: MutableList<Movimiento> = mutableListOf()
    private var idMovimiento = 0

    init {
        if (!validarIban(iban)) {
            throw IllegalArgumentException("El IBAN no es válido.")
        }
    }

    // Validación básica del IBAN
    private fun validarIban(iban: String): Boolean {
        return iban.matches(Regex("[A-Z]{2}[0-9]{22}"))
    }

    // Método para obtener los datos de la cuenta
    fun obtenerDatosCuenta() {
        println("IBAN: $iban")
        println("Titular: $titular")
        println("Saldo: $saldo€")
    }

    // Método para obtener el saldo disponible
    fun obtenerSaldo() {
        println("Saldo disponible: $saldo€")
    }

    // Método para realizar un ingreso
    fun ingresarDinero(cantidad: Double) {
        if (cantidad > 0) {
            saldo += cantidad
            registrarMovimiento("Ingreso", cantidad)
            println("Ingreso realizado correctamente. Saldo actual: $saldo€")
        } else {
            println("La cantidad a ingresar debe ser mayor que 0.")
        }
    }

    // Método para realizar una retirada
    fun retirarDinero(cantidad: Double) {
        if (cantidad > 0) {
            if (saldo - cantidad >= -50) {
                saldo -= cantidad
                registrarMovimiento("Retirada", cantidad)
                println("Retirada realizada correctamente. Saldo actual: $saldo€")
                if (saldo < 0) {
                    println("AVISO: Saldo negativo.")
                }
            } else {
                println("No puedes retirar esa cantidad. El saldo no puede ser inferior a -50€.")
            }
        } else {
            println("La cantidad a retirar debe ser mayor que 0.")
        }
    }

    // Método para registrar los movimientos
    private fun registrarMovimiento(tipo: String, cantidad: Double) {
        idMovimiento++
        if (movimientos.size == 100) {
            movimientos.removeAt(0)
        }
        movimientos.add(Movimiento(idMovimiento, tipo, cantidad))
    }

    // Método para mostrar el historial de movimientos
    fun mostrarMovimientos() {
        if (movimientos.isEmpty()) {
            println("No hay movimientos registrados.")
        } else {
            movimientos.forEach { println(it) }
        }
    }
}