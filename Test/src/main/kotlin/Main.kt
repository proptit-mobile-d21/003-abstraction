interface UsableElectricity { //
    val isUseElectricity: Boolean
}

interface Function {
    val purpose: String
}

// Một Class có thể kế thừa nhiều Interface
abstract class Item(price: Int) : Function, UsableElectricity {
    abstract fun showPrice() // phương thức showPrice bắt buộc phải được triển khai tại các Class con
}

// Lưu trạng thái của thuộc tính từ Interface
interface Furniture : UsableElectricity {
    override val isUseElectricity: Boolean
        get() = false
}

interface Appliance : UsableElectricity {
    override val isUseElectricity: Boolean
        get() = true
}

class Sofa(private val price: Int) : Item(price), Furniture {
    override fun showPrice() {
        println("A sofa priced at $price");
    }

    override val purpose: String
        get() = "To sit down and relax"
}

class Refrigerator(private val price: Int) : Item(price), Appliance {
    override fun showPrice() {
        println("A Refrigerator priced at $price")
    }

    override val purpose: String
        get() = "To preserve food"
}

fun main(args: Array<String>) {
    val item = listOf<Item>(
        Sofa(10000), Refrigerator(7500), Sofa(15000), Refrigerator(12000)
    )

    item.forEach { x ->
        x.showPrice()
        println(x.purpose)
        println("Is consuming electricity = ${x.isUseElectricity}")
        println()
    }
}