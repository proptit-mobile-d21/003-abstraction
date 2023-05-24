//tac dung cua abstract class

abstract class Shape{
    //abstract property can duoc override
    abstract val vertexCount : Int
    // khoi tao state cho property
    val borderColor = "Red"
    //abstract fun can duoc override
    abstract fun draw()
    // fun with body khong can override
    fun fillColor(){
        println("Filling the border $borderColor")
    }
}

class Rectangle : Shape(){
    //override lai so canh cua hinh chu nhat la 4
    override val vertexCount = 4
    //override
    override fun draw() {
        println("Drawing a Rectangle with $vertexCount vertex.")
    }
}

class Polygon: Shape(){
    //override lai so canh cua 1 da giac, su dung var de co the set so canh
    override var vertexCount = 0
    override fun draw() {
        println("Drawing a Polygon with $vertexCount vertex.")
    }
}

fun main()
{
    val rectangle = Rectangle()
    rectangle.fillColor()
    rectangle.draw()

    val polygon = Polygon()
    polygon.vertexCount = 6
    polygon.draw()
}
