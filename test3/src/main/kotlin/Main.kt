// Định nghĩa một interface "Drawable" mô tả đối tượng có thể vẽ được
interface Drawable {
    fun draw()
}

// Lớp Circle triển khai interface Drawable
class Circle : Drawable {
    override fun draw() {
        println("Drawing a circle")
    }
}

// Lớp Rectangle triển khai interface Drawable
class Rectangle : Drawable {
    override fun draw() {
        println("Drawing a rectangle")
    }
}

// Lớp Triangle triển khai interface Drawable
class Triangle : Drawable {
    override fun draw() {
        println("Drawing a triangle")
    }
}

// Hàm vẽ tất cả các đối tượng Drawable
fun drawAll(drawables: List<Drawable>) {
    for (drawable in drawables) {
        drawable.draw()
    }
}

fun main() {
    // Tạo danh sách các đối tượng Drawable
    val drawables = listOf(Circle(), Rectangle(), Triangle())

    // Gọi hàm vẽ tất cả các đối tượng
    drawAll(drawables)
}