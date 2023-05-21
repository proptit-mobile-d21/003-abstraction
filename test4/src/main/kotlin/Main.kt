// Abstract class
abstract class Animal {
    abstract fun sound()
    fun sleep() {
        println("Zzzzz")
    }
}

// Interface
interface Jumpable {
    fun jump()
}

// Class Dog kế thừa từ abstract class Animal và triển khai interface Jumpable
class Dog : Animal(), Jumpable {
    override fun sound() {
        println("Woof!")
    }

    override fun jump() {
        println("Jumping...")
    }
}

// Class Bird triển khai interface Jumpable
class Bird : Jumpable {
    override fun jump() {
        println("Birds can jump!")
    }
}

fun main() {
    val dog = Dog()
    dog.sound()
    dog.sleep()
    dog.jump()

    val bird = Bird()
    bird.jump()
}