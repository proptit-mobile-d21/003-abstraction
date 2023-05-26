interface Nameable {
    val name: String
}

interface Mortal {
    val yearOfBirth: Int
    val isAlive: Boolean
}

interface Movable {
    fun move() = println("I'm moving")
}

// Có thể kế thừa nhiều Interface nhưng chỉ có thể kế thừa 1 Abstract Class
// Sử dụng Abstract Class vì có những phương thức bắt buộc các Subclass phải định nghĩa như: introduce()
abstract class Creature: Nameable, Mortal {
    abstract val livingYear: Int

    val age:Int
        get() = livingYear - yearOfBirth

    override var isAlive: Boolean = true // Trạng thái hiện tại của Creature (Interface không thể lưu được trạng thái)

    abstract fun introduce()
}

class FanAstralis(override val name: String, override val yearOfBirth: Int) : Creature() {
    override val livingYear: Int = 2019

    override fun introduce() = println("We live in $livingYear, and we have 4 majors!")
}

class Person(override val name: String, override val yearOfBirth: Int) : Creature(), Movable {
    override val livingYear: Int = 2023

    override fun introduce() = println("I'm $name. I'm $age years old")
}

fun main() {
    val csgoViewers = listOf<Creature>(
        FanAstralis("Nguyen Van A", 1998),
        Person("Nguyen Van B", 2003),
        FanAstralis("Nguyen Van C", 2003),
        FanAstralis("Nguyen Van D", 1990),
    )
    csgoViewers.forEach{
        println("---Viewer: ${it.name}---")
        it.introduce()
        if (it is Movable) it.move()
        else println("I'm disabled, I can't move")
    }
}