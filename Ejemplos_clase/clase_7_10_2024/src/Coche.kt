import java.util.*


class Coche (matricula: String, marca:String, acabado :String){

    val matricula: String
    val marca: String
    var acabado: String
    var bastidor: String

    init {
        this.matricula = matricula
        this.marca = marca
        this.acabado = acabado
        this.bastidor = UUID.randomUUID().toString();
        //Validar cualquier cosa
    }

    constructor(matricula: String, marca:String, acabado :String, bastidor:String)
            :this(matricula, marca, acabado){
                this.bastidor = bastidor
    }

}

