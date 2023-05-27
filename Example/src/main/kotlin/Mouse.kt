class Mouse(val name: String) : Animal(name), Prey{
    override val legs: Int = 2
    override val type: String
        get() = "mouse"
    override fun showName() {
        println("This is a $type named: $name")
    }
    //override fun showMessage() {}
    // error because showMessage is declared with "final"

   // don't need to override action value because it already has a getter.
}