abstract class Animal {
    abstract fun sound()
    fun sleep() {
        println("The animal is sleeping")
    }
}

class Dog : Animal() {
    override fun sound() {
        println("Woof woof!")
    }
}

class Cat : Animal() {
    override fun sound() {
        println("Meow!")
    }
}

fun main() {
    val dog = Dog()
    dog.sound()
    dog.sleep()

    val cat = Cat()
    cat.sound()
    cat.sleep()
}
