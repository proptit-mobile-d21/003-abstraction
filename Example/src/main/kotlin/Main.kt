

fun main() {
    val cat = Cat("Tom")
    val mouse = Mouse("Jerry")
    val dog = Dog("Spike")

    println("\n---After initializing---\n")

    cat.showName()
    cat.isMove()
    cat.isHunting(cat.name)
    cat.isRunning(cat.name)
    println(cat.action) // action in this line has been overrided

    println("---")

    mouse.showName()
    mouse.isMove()
    mouse.isRunning(mouse.name)
    println(mouse.action) // action in this line is from interface.

    println("---")

    dog.showName()
    dog.isMove()
    dog.isHunting(dog.name)
    println(dog.action) // action in this line has been overrided
}