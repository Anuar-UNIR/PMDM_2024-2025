

class CuentaBancaria (val iban: String, val titular: String) {

    private var saldo: Double = 0.0
    private var idMovimiento: Int = 0
    private val movimientos: MutableList<Movimiento> = mutableListOf()



    init {
        if (!validarIban(iban)){
            //Excepcion arbitraria
            throw IllegalArgumentException("El IBAN no es valido")
        }
    }

    //Validar titular
    private fun validarTitular(titular: String): Boolean{
        var isOk = false
         if(titular.length >= 3) {
            isOk = true
        }
        return isOk
    }

    //Validar formato IBAN
    private fun validarIban(iban: String): Boolean{
        return iban.matches(Regex("[A-Z]{2}[0-9]{22}"))
    }



    fun obtenerSaldo(): Double {
        return this.saldo
    }



    //Complemento validador generico
    private fun validadorPatron(texto: String, patron: String): Boolean{
        return texto.matches(Regex(patron))
    }

}