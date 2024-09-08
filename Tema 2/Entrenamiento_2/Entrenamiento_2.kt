fun main() {
    // Solicitar la hora, minutos y segundos al usuario
    println("Introduce la hora (0-23):")
    var horas = readLine()?.toIntOrNull() ?: return
    println("Introduce los minutos (0-59):")
    var minutos = readLine()?.toIntOrNull() ?: return
    println("Introduce los segundos (0-59):")
    var segundos = readLine()?.toIntOrNull() ?: return

    // Validar si los valores introducidos son correctos
    if (horas !in 0..23 || minutos !in 0..59 || segundos !in 0..59) {
        println("Los valores introducidos no son válidos.")
        return
    }else{

        segundos = segundos + 1

        // Ajustar los segundos, minutos y horas si es necesario
        if (segundos == 60) {
            segundos = 0
            minutos += 1

            if (minutos == 60) {
                minutos = 0
                horas += 1

                if (horas == 24) {
                    horas = 0
                }
            }
        }

        // Mostrar el resultado
        println("La hora transcurrido un segundo será: %02d:%02d:%02d".format(horas, minutos, segundos))

    }
}