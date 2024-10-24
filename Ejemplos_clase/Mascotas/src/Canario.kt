import java.util.Date

class Canario (nombre: String, edad: Int, estado: String, fechaNacimiento: Date, pico: String, vuela: Boolean,
               val color: String, val canta: Boolean) : Aves(nombre, edad, estado, fechaNacimiento, pico, vuela){


    override fun volar() {
        if(this.vuela){
            println("El loro ${this.nombre} vuela muy bien")
        }
        else{
            println("El loro ${this.nombre}no sabe volar")
        }
    }

    override fun muestra() {
        println("Canario - Nombre: ${this.nombre}, color: ${this.color}, Edad: ${this.edad}, Estado: ${this.estado}, " +
                "Fecha de Nacimiento: ${this.fechaNacimiento}, Pico: ${this.pico}, Vuela: ${this.vuela} Canta ${this.canta}")
    }

    override fun habla() {
        println("Soy un canario  y digo pio pio")
    }
}