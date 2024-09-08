import java.util.*

// Clase Canario
class Canario(nombre: String, edad: Int, estado: String, fechaNacimiento: Date, pico: String, vuela: Boolean, val color: String, val canta: Boolean = true)
    : Aves(nombre, edad, estado, fechaNacimiento, pico, vuela) {

    override fun muestra() {
        println("Canario - Nombre: ${this.nombre}, Color: ${this.color}, Edad: ${this.edad}, Estado: ${this.estado}, " +
                "Fecha de Nacimiento: ${this.fechaNacimiento}, Pico: ${this.pico}, Vuela: ${this.vuela}")
    }

    override fun habla() {
        println("${this.nombre} dice: Pío Pío")
    }

    override fun volar() {
        if (this.vuela) {
            println("${this.nombre} está volando.")
        } else {
            println("${this.nombre} no puede volar.")
        }
    }

    override fun cumpleMascota() {
        println("Mi cumple años es ${this.fechaNacimiento.day}/${this.fechaNacimiento.month}: Pio Pio")
    }

    override fun morir() {
        println("Aun soy muy joven para morir: Pio Pio")
    }
}