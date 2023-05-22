package Mobile_003

// Kết hợp cả Interface và Abstract class
interface Food {
    val name: String
    fun displayInfo()
}
abstract class FoodType : Food {
    abstract val ingredients: List<String>
    abstract val price: Long

    override fun displayInfo() {
        println("Name: $name")
        println("Ingredients: ${ingredients.joinToString(", ")}")
        println("Price: $price đ")
    }
}
class Rice(override val name: String, override val ingredients: List<String>,
            override val price: Long) : FoodType()
class Banhmy(override val name: String, override val ingredients: List<String>,
             override val price: Long) : FoodType()
class Noodle(override val name: String, override val ingredients: List<String>,
            override val price: Long) : FoodType()

fun main() {
    val ComTam = Rice("Cơm tấm",
        listOf("Cơm", "Sườn nướng", "Bì trộn", "Chả trứng"), 50000)
    val BanhMy = Banhmy("Bánh mỳ Việt Nam",
        listOf("Bánh mỳ", "Pate", "Chả", "Dưa góp"), 20000)
    val MyTom = Noodle("Mỳ tôm trứng xúc xích",
        listOf("Mỳ tôm", "Trứng", "Xúc xích"), 25000)
    ComTam.displayInfo()
    BanhMy.displayInfo()
    MyTom.displayInfo()
}