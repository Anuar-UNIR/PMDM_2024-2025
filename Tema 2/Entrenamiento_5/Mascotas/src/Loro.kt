import java.util.*

// Clase Loro
class Loro(nombre: String, edad: Int, estado: String, fechaNacimiento: Date, pico: String, vuela: Boolean, val origen: String, val habla: Boolean = true)
    : Aves(nombre, edad, estado, fechaNacimiento, pico, vuela) {

    override fun muestra() {
        println("Loro - Nombre: ${this.nombre}, Origen: ${this.origen}, Edad: ${this.edad}, Estado: ${this.estado}, " +
                "Fecha de Nacimiento: ${this.fechaNacimiento}, Pico: ${this.pico}, Vuela: ${this.vuela}")
    }

    override fun habla() {
        println("${this.nombre} dice: ¡Hola! Soy un loro")
    }

    override fun volar() {
        if (this.vuela) {
            println("${this.nombre} está volando.")
        } else {
            println("${this.nombre} no puede volar.")
        }
    }

    override fun cumpleMascota() {
        println("Mi cumple años es ${this.fechaNacimiento.day}/${this.fechaNacimiento.month}: ¡Hola! Soy un loro")
    }

    override fun morir() {
        println("Aun soy muy joven para morir: ¡Hola! Soy un loro")
    }
}