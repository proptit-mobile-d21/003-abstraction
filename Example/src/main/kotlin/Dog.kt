class Dog(val name: String) : Animal(name){
    override val legs: Int = 4
    override val type: String
        get() = "dog"
    override fun showName() {
        println("This is a $type named: $name")
    }
    //override fun showMessage() {}
    // error because showMessage is declared with "final"
}