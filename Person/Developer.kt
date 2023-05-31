class Developer(name: String) : Person(name), Activity, Favourite, OtherInformation{
    override val age: Int = 20

    override val address: String = "Ha Noi"

    override val action: String = "Coding"

    override fun Show() {
        println(age)
        println(address)
    }
}