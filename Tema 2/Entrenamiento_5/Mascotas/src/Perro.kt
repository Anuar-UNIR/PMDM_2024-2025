import java.util.*

// Clase Perro
class Perro(nombre: String, edad: Int, estado: String, fechaNacimiento: Date, val raza: String, val pulgas: Boolean)
    : Mascota(nombre, edad, estado, fechaNacimiento) {

    override fun muestra() {
        println("Perro - Nombre: ${this.nombre}, Raza: ${this.raza}, Edad: ${this.edad}, Estado: ${this.estado}, " +
                "Fecha de Nacimiento: ${this.fechaNacimiento}, Pulgas: ${this.pulgas}")
    }

    override fun cumpleMascota() {
        println("Mi cumple años es ${this.fechaNacimiento.day}/${this.fechaNacimiento.month}: Guau Guau")
    }

    override fun morir() {
        println("Aun soy muy joven para morir: Guau Guau")
    }

    override fun habla() {
        println("${this.nombre} dice: Guau Guau")
    }
}