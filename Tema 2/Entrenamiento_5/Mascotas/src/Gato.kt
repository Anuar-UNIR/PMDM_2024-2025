import java.util.*

// Clase Gato
class Gato(nombre: String, edad: Int, estado: String, fechaNacimiento: Date, val color: String, val peloLargo: Boolean)
    : Mascota(nombre, edad, estado, fechaNacimiento) {

    override fun muestra() {
        println("Gato - Nombre: ${this.nombre}nombre, Color: ${this.color}, Edad: ${this.edad}, Estado: ${this.estado}," +
                " Fecha de Nacimiento: ${this.fechaNacimiento}, Pelo Largo: ${this.peloLargo}")
    }

    override fun habla() {
        println("${this.nombre} dice: Miau Miau")
    }

    override fun cumpleMascota() {
        println("Mi cumple años es ${this.fechaNacimiento.day}/${this.fechaNacimiento.month}: Miau Miau")
    }

    override fun morir() {
        println("Aun soy muy joven para morir: Miau Miau")
    }
}