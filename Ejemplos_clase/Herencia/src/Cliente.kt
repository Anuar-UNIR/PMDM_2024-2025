class Cliente : Persona {
    val dni: String
    constructor(nombre: String, dni: String) : super(nombre){
        this.dni = dni


    }

    override fun registrarCenso(localidad: String){
        println("Te has censado en ${localidad} como cliente premium")
        super.registrarCenso(localidad)
    }

    override fun toString(): String {
        return super.toString() + " Cliente(dni='$dni')"
    }


}