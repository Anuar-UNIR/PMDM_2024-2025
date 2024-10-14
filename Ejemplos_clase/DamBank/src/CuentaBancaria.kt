

class CuentaBancaria (val iban: String, val titular: String) {

    private var saldo: Double = 0.0
    private var idMovimiento: Int = 0
    private val movimientos: MutableList<Movimiento> = mutableListOf()


    init {
        if (!validarIban(iban)) {
            //Excepcion arbitraria
            throw IllegalArgumentException("El IBAN no es valido")
        }
    }

    fun obtenerDatosCuentaBancaria(): String{
        return "Datos de la cuenta: IBAN: ${this.iban} Titular: ${this.titular} Saldo: ${this.saldo}"
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


    fun ingresarDinero(cantidad: Double){
        if(cantidad > 0.0){
            this.saldo += cantidad
            //crear movimiento
            registrarMovimiento(cantidad, "Ingreso")
        }
        else{
            println("La cantaidad debe de ser positiva")
        }
    }

    fun retirarDinero(cantidad: Double){
        if(cantidad > 0.0){
            if(this.saldo - cantidad >= -50)
            {
                this.saldo -= cantidad

                registrarMovimiento(cantidad, "Retirada")
            }
            else{
                println("No puedes retirar esta cantidad. El saldo no puede ser menor que -50€")
            }
        }
        else{
            println("La cantaidad debe de positiva")
        }
    }


    fun mostrarMovimientos()
    {
        if(movimientos.isEmpty()){
            println("No hay movimientos registrados")
        }
        else{
            this.movimientos.forEach { println(it) }
        }
    }

    private fun registrarMovimiento(cantidad: Double, tipo: String) {
        val mo = Movimiento(this.idMovimiento, tipo, cantidad)
        this.movimientos.add(mo)
        this.idMovimiento++
    }


    //Complemento validador generico
    private fun validadorPatron(texto: String, patron: String): Boolean{
        return texto.matches(Regex(patron))
    }

}