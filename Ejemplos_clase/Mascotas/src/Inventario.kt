class Inventario {

    private val animales: MutableList<Mascota> = mutableListOf<Mascota>();


    fun mostrarAnimales(){
        if(animales.isEmpty()){
            println("No hay animales en nuestro inventario")
        }
        else{
            animales.forEach { animale ->
                println("${animale::class.simpleName} - Nombre: ${animale.nombre}")
            }
        }
    }

    fun mostrarDatosAnimal(nombre: String){
        val animal = animales.find { it.nombre == nombre }

        if(animal != null){
            animal.muestra()
        }
        else{
            println("No hay animales en nuestro inventario con ese nombre")
        }
    }

    fun mostrarAnimalesCompletos(){
        if(animales.isEmpty()){
            println("No hay animales en nuestro inventario")
        }
        else{
            animales.forEach { animale ->
                animale.muestra()
            }
        }
    }




}