//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

/*    val miCoche = Coche("3222DPZ","Aston Martin", "SportLine")


    val coche2 = Coche("5555DPZ","Ferrari", "SportLine")


    val coche3 = Coche("5555DPZ","Ferrari", "SportLine","JH7998878")
    coche3.bastidor = "gggggg"

    println("Coche2: "+coche2.bastidor)
    println("Coche3: "+coche3.bastidor)*/

    val pp = Persona("Pepe", 40)
    pp.peso = 101.0

    pp.sobrePeso = true


    println("¿Sobrepeso?:${if (pp.sobrePeso) "SI" else "NO"}")
    println(pp.peso)


}