interface Mamifero {

    val p1: Int // Propiedad abstracta

    val p2: Boolean // Propiedad regular con accesor
        get() = p1 > 0

    fun m1() // Método abstracto

    fun m2() { // Método regular
        print("Método implementado")
    }

}