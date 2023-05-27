interface Prey {
    val action: String
        get() = "Hiding from danger." //using getter to

    fun isRunning(name: String){
        println("$name is running from predators.")
    }
}