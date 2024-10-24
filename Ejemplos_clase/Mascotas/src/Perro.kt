import java.util.Date

class Perro (nombre:String, edad: Int, estado: String, fechaNacimiento:Date,
    val raza: String, var pulgas: Boolean) : Mascota(nombre, edad, estado, fechaNacimiento) {

    override fun muestra() {
        val mensaje: String = "Esta mascota es un perro - Nombre: $nombre - Edad: $edad - Fecha: $fechaNacimiento " +
        "Raza: $raza Pulgas: $pulgas"
        println(mensaje)
    }

    override fun habla() {
        println("Soy un perro y digo Guau Guauu")
    }


}