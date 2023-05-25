//tac dung cua interface

interface Engine{
    fun startEngine()
}

class Car(val name: String, val color: String) : Engine{
    override fun startEngine() {
        println("The car $name is starting the engine.")
    }

}

class Truck(val name: String, val color: String) : Engine{
    override fun startEngine() {
        println("The truck $name is starting the engine.")
    }

}

class Plane(val name: String, val color: String): Engine{
    override fun startEngine() {
        println("The plane $name is starting the engine.")
    }


}

fun main()
{
    val car = Car("Porsche", "Blue")
    val truck = Truck("YMH", "White")
    val plane = Plane("VietX", "Red")
    car.startEngine()
    truck.startEngine()
    plane.startEngine()

}
