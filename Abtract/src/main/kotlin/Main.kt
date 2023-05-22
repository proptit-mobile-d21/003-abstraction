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

fun main(){
    val dog = Dog()
    dog.makeSound()
    dog.eat()
}