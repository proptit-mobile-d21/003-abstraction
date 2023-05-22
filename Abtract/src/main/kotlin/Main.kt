abstract class Animal{
    abstract fun makeSound()
    fun eat(){
        println("I am eating")
    }
}

class Dog: Animal(){
    override fun makeSound() {
        println("Go go go!!!")
    }
}
interface IFlyable{
    fun fly()
}
class Bird: Animal(), IFlyable {
    override fun makeSound() {
        println("Chirp chirp")
    }

    override fun fly() {
        println("I am flying")
    }
}
class Plane: IFlyable{
    override fun fly() {
        println("Plane is flying")
    }
}
fun main(){
    val dog = Dog()
    dog.makeSound()
    dog.eat()

    val bird = Bird()
    bird.makeSound()
    bird.fly()

    val plane = Plane()
    plane.fly()


}