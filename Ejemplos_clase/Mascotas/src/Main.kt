import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val inventario = Inventario()

    inventario.insertarAnimales(Perro("Auri", 9,"Saludable", Date(),
        "Alaska Malamute", false))
    inventario.insertarAnimales(Gato("Mimi", 2, "Jugueton", Date(), "Gris", true))
    inventario.insertarAnimales(Loro("Pepe", 5, "Saludable", Date(), "Naranja y largo",
        true, "America", true))
    inventario.insertarAnimales(Canario("Piolin", 7, "Saludable", Date(), "pequeño",
        true, "amarillo", true))


    println("Mostrar todos los animales solo tipo y nombre")
    inventario.mostrarAnimales()

    println("Mostrar toda la informacion de todos los animales")
    inventario.mostrarAnimalesCompletos()

    println("Mostrar la información de Auri: ")
    inventario.mostrarDatosAnimal("Auri")

    println("Eliminar el animal con nombre Mimi")
    inventario.eliminarAnimales(("Mimi"))

    println("Mostrar todos los animales solo tipo y nombre")
    inventario.mostrarAnimales()

    println("Dar en adopcion a todos los animales")
    inventario.vaciarInventario()

    println("Mostrar todos los animales solo tipo y nombre")
    inventario.mostrarAnimales()


}