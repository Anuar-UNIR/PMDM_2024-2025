//Importamos la libreria random para generar numeros aleatorios
import kotlin.random.Random

fun main() {
    //Damos la bienvenida al juego y mostramos las reglas
    // Menú principal del juego
    println("Bienvenido al juego de Piedra, Papel o Tijera")
    println("Por favor, elige una opción:")
    println("1. Piedra")
    println("2. Papel")
    println("3. Tijera")

    // Leer la elección del jugador si no insertamos nada le da un valor de 0
    val opcionJugador = readLine()?.toIntOrNull() ?: 0

    // Validar la elección del jugador
    if (opcionJugador !in 1..3) {
        println("Opción inválida. Debes elegir un número entre 1 y 3.")
        return
    }

    // Obtener la elección de la computadora de forma aleatoria
    val opcionComputadora = Random.nextInt(1, 4)

    // Mostrar las opciones elegidas. Usamos la funcion opcionAString para mostrarlo en formato texto
    println("Tú elegiste: ${opcionAString(opcionJugador)}")
    println("La computadora eligió: ${opcionAString(opcionComputadora)}")

    // Determinar el resultado del juego mediante la funcion determinarGanador
    val resultado = determinarGanador(opcionJugador, opcionComputadora)

    // Mostrar el resultado
    println(resultado)
}

//Fuera de la funcion main definimos las funciones auxiliares

// Función para convertir la opción numérica a texto mediante la estructura when
fun opcionAString(opcion: Int?): String {
    return when (opcion) {
        1 -> "Piedra"
        2 -> "Papel"
        3 -> "Tijera"
        else -> "Opción desconocida"
    }
}

// Función para determinar el ganador
fun determinarGanador(jugador: Int, computadora: Int): String {
    //Comprobamos las opciones de ganar y perder
    return if (jugador == computadora) {
        "¡Empate!"
    } else if ((jugador == 1 && computadora == 3) ||  // Piedra gana a Tijera
        (jugador == 2 && computadora == 1) ||  // Papel gana a Piedra
        (jugador == 3 && computadora == 2)) {  // Tijera gana a Papel
        "¡Ganaste!"
    } else {
        "Perdiste, la computadora ganó."
    }
}