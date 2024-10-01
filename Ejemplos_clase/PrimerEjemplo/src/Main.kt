//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val sum = suma(b = 27, a = 3)

    println("La suma es $sum")



    for(i in 1..5){
        println("Contando $i")
    }

    for (char in 'a'..'k') {
        print(char)
    }

    val nombres = arrayOf("Carlos", "Sergio", "Juan", "Gerardo", "Manuel")
    for (i in nombres.indices) {
        println("[$i, ${nombres[i]}]")
    }


}//fun main

fun square (x: Int): Int {
    return x * x
}


fun saludar (nombre: String) :Unit{
    println(nombre)
}

fun suma (a: Int = 11, b: Int = 2) = a + b;




