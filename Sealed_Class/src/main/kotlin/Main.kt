sealed class Shape{
    object None : Shape()
    data class Rectangle(val width: Int, val height: Int) : Shape()
    data class Circle(val radius: Int) : Shape()
}

fun main(){

}