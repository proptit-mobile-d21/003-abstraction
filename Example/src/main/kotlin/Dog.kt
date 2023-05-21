class Dog(val name: String) : Animal(name){
    override val legs: Int = 4
    override val type: String
        get() = "dog"
    override fun showName() {
        println("This is a $type named: $name")
    }
 // Have to override action value because it hasn't been defined yet.
}