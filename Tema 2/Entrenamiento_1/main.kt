fun main() {
    // Solicitar la calificación numérica al usuario
    println("Introduce una calificacion numerica entre 0 y 10:")

    //Utilizamos los operadores especiales de kotlin de tal forma que si no se inserta nada por pantalla finalizamos el programa
    val calificacion = readLine()?.toDoubleOrNull() ?: return

    // Determinar la calificación alfabética usamos la sentencia when propia de Kotlin
    val resultado = when {
        calificacion < 0 || calificacion > 10 -> "Calificacion invalida"
        calificacion < 3 -> "Muy Deficiente"
        calificacion < 5 -> "Insuficiente"
        calificacion < 6 -> "Bien"
        calificacion < 9 -> "Notable"
        calificacion <= 10 -> "Sobresaliente"
        else -> "Calificación inválida"
    }

    // Mostrar el resultado
    println("Tu calificacion es: $resultado")
}