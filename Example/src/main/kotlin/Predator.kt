interface Predator {
    val action: String

    fun isHunting(name: String){
        println("$name is searching for preys.")
    }
}