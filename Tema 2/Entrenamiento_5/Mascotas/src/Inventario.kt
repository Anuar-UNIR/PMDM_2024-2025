class Inventario {

    // Almacenamiento privado de los animales
    private val animales: MutableList<Mascota> = mutableListOf()

    // Mostrar solo el tipo y nombre de los animales
    fun mostrarListaAnimales() {
        if (animales.isEmpty()) {
            println("El inventario está vacío.")
        } else {
            animales.forEach { animal ->
                println("${animal::class.simpleName} - Nombre: ${animal.nombre}")
            }
        }
    }

    // Mostrar todos los datos de un animal concreto (por nombre)
    fun mostrarDatosAnimal(nombre: String) {
        val animal = animales.find { it.nombre == nombre }
        if (animal != null) {
            animal.muestra()
        } else {
            println("No se encontró ningún animal con el nombre $nombre.")
        }
    }

    // Mostrar todos los datos de todos los animales
    fun mostrarDatosTodosLosAnimales() {
        if (animales.isEmpty()) {
            println("El inventario está vacío.")
        } else {
            animales.forEach { it.muestra() }
        }
    }

    // Insertar un nuevo animal
    fun insertarAnimal(animal: Mascota) {
        animales.add(animal)
        println("${animal.nombre} ha sido añadido al inventario.")
    }

    // Eliminar un animal del inventario (por nombre)
    fun eliminarAnimal(nombre: String) {
        val animal = animales.find { it.nombre == nombre }
        if (animal != null) {
            animales.remove(animal)
            println("$nombre ha sido eliminado del inventario.")
        } else {
            println("No se encontró ningún animal con el nombre $nombre.")
        }
    }

    // Vaciar todo el inventario
    fun vaciarInventario() {
        animales.clear()
        println("El inventario ha sido vaciado.")
    }
}