interface Prey {
    val action: String
        get() = "Hiding from danger."

    fun isRunning(name: String){
        println("$name is running from predators.")
    }
}