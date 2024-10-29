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
            println("No hay animales en nuestro inventario con el ${nombre}")
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

    fun insertarAnimales(animal: Mascota){
        this.animales.add(animal)
        println("${animal.nombre} ha sido insertado en el inventario")
    }

    fun eliminarAnimales(nombre : String){
        val animal = animales.find { it.nombre == nombre }
        if(animal != null){
            this.animales.remove(animal)
            println("${animal.nombre} ha sido eliminado del inventario")
        }
        else{
            println("No se ha encontrado en el inventario ningun animal con el nombre ${nombre}")
        }
    }

    fun eliminarAnimales(nombre : String, tipo: String){
        val animal = animales.find { it.nombre == nombre  &&  it::class.simpleName == tipo }
        if(animal != null){
            this.animales.remove(animal)
            println("${animal.nombre} ha sido eliminado del inventario")
        }
        else{
            println("No se ha encontrado en el inventario ningun animal con el nombre ${nombre}")
        }
    }

    fun vaciarInventario(){
        this.animales.clear()
        println("Se han dado en adopcion todos los animales")
    }




}