import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val inventario = Inventario()

    // Insertamos algunos animales de prueba
    inventario.insertarAnimal(Perro("Bobby", 3, "Vivo", Date(), "Labrador", true))
    inventario.insertarAnimal(Gato("Mimi", 2, "Vivo", Date(), "Gris", true))
    inventario.insertarAnimal(Loro("Pepe", 5, "Vivo", Date(), "Corto", true, "Brasil"))
    inventario.insertarAnimal(Canario("Amarillo", 1, "Vivo", Date(), "Corto", true, "Amarillo"))

    // Mostrar todos los animales (tipo y nombre)
    println("Lista de animales en el inventario:")
    inventario.mostrarListaAnimales()

    // Mostrar todos los datos de un animal concreto
    println("\nDatos del animal llamado Mimi:")
    inventario.mostrarDatosAnimal("Mimi")

    // Mostrar todos los datos de todos los animales
    println("\nDatos de todos los animales en el inventario:")
    inventario.mostrarDatosTodosLosAnimales()

    // Eliminar un animal
    println("\nEliminando a Bobby del inventario:")
    inventario.eliminarAnimal("Bobby")
    inventario.mostrarListaAnimales()

    // Vaciar el inventario
    println("\nVaciando el inventario:")
    inventario.vaciarInventario()
    inventario.mostrarListaAnimales()
}