import kotlin.math.PI

sealed class Shape{
    object None : Shape()
    data class Rectangle(val width: Int, val height: Int) : Shape()
    data class Circle(val radius: Int) : Shape()
}

fun area(shape : Shape) = when(shape){
    is Shape.None -> 0
    is Shape.Circle -> shape.radius * shape.radius * PI
    is Shape.Rectangle -> shape.height * shape.width
}
fun main(){
    val circle = Shape.Circle(5);
    println(area(circle));
    val rectangle = Shape.Rectangle(3, 4)
    println(area(rectangle))
}