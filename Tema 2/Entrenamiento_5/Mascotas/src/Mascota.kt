
import java.util.Date

// Clase abstracta Mascota
abstract class Mascota(val nombre: String, var edad: Int, var estado: String, val fechaNacimiento: Date) {
    abstract fun muestra()
    abstract fun cumpleMascota()
    abstract fun morir()
    abstract fun habla()
}