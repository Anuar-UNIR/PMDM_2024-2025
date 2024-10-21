open class Persona (val nombre: String){


    open fun registrarCenso(localidad: String){
        println("Te has censado en ${localidad}");
    }

    override fun toString(): String {
        return "Persona(nombre='$nombre')"
    }


}