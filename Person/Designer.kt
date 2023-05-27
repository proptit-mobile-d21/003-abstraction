class Designer(name: String) : Person(name) , Activity, Favourite, OtherInformation{
    override val age: Int = 21

    override val address: String = "Thai Binh"

    override val action: String = "Designing"

    override fun Show() {
        println(age)
        println(address)
    }
}