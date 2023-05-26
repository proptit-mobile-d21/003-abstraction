import kotlin.math.PI

sealed class Shape{

    data class Rectangle(val width: Int, val height: Int) : Shape()
    data class Circle(val radius: Int) : Shape()
}
data class Rohombus(val height: Int, val width: Int) : Shape()


enum class EnumShape(string: String){
    None("None"),
    Rectangle("Rectangle"),
    Circle("Circle")
}
fun area(shape : Shape) = when(shape){
   // is Shape.None -> 0
    is Shape.Circle -> shape.radius * shape.radius * PI
    is Shape.Rectangle -> shape.height * shape.width
    is Rohombus -> shape.height * shape.width
}
fun main(){
    val circle = Shape.Circle(5);
    println(area(circle));
    val rectangle = Shape.Rectangle(3, 4)
    println(area(rectangle))

    /*
    * Các enum constant chỉ có 1 kiểu khai báo (giống với enum class) và tồn tại như 1 instance của enum class.
    * VD: các enum constance của EnumShape bắt buộc phải có thuộc tính string còn các enum constance của Shape thì không.
    * Các enum constant chỉ có thể nằm trong body của enum class còn của sealed class thì có thể nằm ở ngoài body của sealed class.
    * */
}