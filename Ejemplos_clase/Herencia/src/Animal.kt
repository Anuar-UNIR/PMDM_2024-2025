abstract class Animal {

    abstract val name: String

    abstract fun asignarDueño()

    fun comer(comida: String){
        println("Hoy he comida: $comida")
    }


}