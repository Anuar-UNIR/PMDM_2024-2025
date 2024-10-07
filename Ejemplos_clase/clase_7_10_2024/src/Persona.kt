

class Persona(val nombre: String, var edad: Int) {


    val isMayorEdad
        get() = this.edad >= 18


    var sobrePeso = false

    var peso = 0.0
        set(value) {
            field = value
            sobrePeso = value > 100
        }
}