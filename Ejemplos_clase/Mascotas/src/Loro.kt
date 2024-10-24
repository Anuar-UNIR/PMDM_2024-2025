import java.util.Date

class Loro (nombre: String, edad: Int, estado: String, fechaNacimiento: Date, pico: String, vuela: Boolean,
            val origen: String, val habla: Boolean = true) : Aves(nombre, edad, estado, fechaNacimiento, pico, vuela) {


    override fun volar() {
        if(this.vuela){
            println("El loro ${this.nombre} vuela muy bien")
        }
        else{
            println("El loro ${this.nombre}no sabe volar")
        }
    }

    override fun muestra() {
        println("Loro - Nombre: ${this.nombre}, Origen: ${this.origen}, Edad: ${this.edad}, Estado: ${this.estado}, " +
                "Fecha de Nacimiento: ${this.fechaNacimiento}, Pico: ${this.pico}, Vuela: ${this.vuela}")
    }

    override fun habla() {
        println("El loro ${this.nombre} repite todo")
    }
}