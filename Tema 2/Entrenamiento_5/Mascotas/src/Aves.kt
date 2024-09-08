
import java.util.Date

// Clase abstracta Aves
abstract class Aves(nombre: String, edad: Int, estado: String, fechaNacimiento: Date, var pico: String, var vuela: Boolean)
    : Mascota(nombre, edad, estado, fechaNacimiento) {
    abstract fun volar()

}