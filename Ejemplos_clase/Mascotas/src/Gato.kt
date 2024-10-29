import java.util.Date

class Gato (nombre:String, edad: Int, estado: String, fechaNacimiento: Date, val color: String,
    val peloLargo: Boolean) : Mascota(nombre, edad, estado, fechaNacimiento){


    override fun muestra() {
        val mensaje: String = "Esta mascota es un gato - Nombre: $nombre - Edad: $edad - Fecha: $fechaNacimiento " +
                "peloLargo: $peloLargo, Color: $color"
        println(mensaje)
    }

    override fun habla() {
        println("Soy un gato y digo Miauu Miauu")
    }
}