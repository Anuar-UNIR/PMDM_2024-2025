import java.util.Date

abstract class Aves (nome:String, edad: Int, estado: String, fechaNacimiento: Date, val pico: String, val vuela: Boolean)
    : Mascota(nome, edad, estado, fechaNacimiento) {

        abstract fun volar()
        
}