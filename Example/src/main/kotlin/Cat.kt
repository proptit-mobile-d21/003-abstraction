class Cat(val name: String) : Animal(name){
    override val legs: Int = 4
    override val type: String
        get() = "cat"
    override fun showName() {
        println("This is a $type named: $name")
    }
    //override fun showMessage() {}
    // error because showMessage is declared with "final"

}