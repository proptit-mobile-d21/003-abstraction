interface UsableElectricity {

}

interface License {
    fun legalItem(name: String) {
        println("A $name is legal")
    }
}

abstract class Item(val price: Int) {
    abstract fun showPrice()
    abstract val name: String
    abstract val purpose: String
}

class Sofa(price: Int) : Item(price), License {
    override val name = "Sofa"
    override fun showPrice() {
        println("A $name priced at $price")
    }

    override val purpose = "To sit down and relax"
}

class Refrigerator(price: Int) : Item(price), UsableElectricity, License {
    override val name = "Refrigerator"
    override fun showPrice() {
        println("A $name priced at $price");
    }

    override val purpose = "To preserve food"
}

class Cigarette(price: Int) : Item(price) {
    override val name = "Cigarette"
    override fun showPrice() {
        println("A $name priced at $price");
    }

    override val purpose = "To preserve food"
}

fun main(args: Array<String>) {
    val item = listOf<Item>(
        Sofa(10000), Refrigerator(7500), Sofa(15000), Cigarette(12000)
    )

    item.forEach { x ->
        x.showPrice()
        println(x.purpose)
        println("Is consuming electricity = ${x is UsableElectricity}")
        if (x is License) x.legalItem(x.name)
        println()
    }
}