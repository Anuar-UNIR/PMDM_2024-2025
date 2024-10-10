import java.text.SimpleDateFormat
import java.util.*

class Movimiento (val id: Int, val tipo: String, val cantidad: Double){

    // Es posible guardar el campo como date y modificar el formato en la clase principal
    val fecha: String = this.obtenerFechaActual()

    private fun obtenerFechaActual(): String {
        return SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date())
    }

    override fun toString(): String {
        return "ID: $id, tipo: $tipo, cantidad: $cantidad, fecha: $fecha"
    }

}