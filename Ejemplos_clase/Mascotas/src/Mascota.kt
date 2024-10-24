import java.util.Date

abstract class Mascota  (val nombre: String, var edad: Int, var estado: String,
                         val fechaNacimiento: Date){

    abstract fun muestra()

    fun cumpleMascota(){
        println("El cumple de esta mascota es ${fechaNacimiento.toString()}")
    }

    fun morir(){
        println("Lamentablemente tengo que dejar este mundo")

    }

    abstract fun habla()
}