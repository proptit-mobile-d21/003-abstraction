class Cat(val name: String) : Animal(name), Predator, Prey{
    override val legs: Int = 4
    override val type: String
        get() = "cat"
    override fun showName() {
        println("This is a $type named: $name")
    }
    //override fun showMessage() {}
    // error because showMessage is declared with "final"

    override val action = "Searching for cat and hiding from dog"
    //Must override action value because both Predator and Pray interfaces have action value.
}