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

    /*
        - Class Bird và Dog đều kế thừa từ class Animal, nhưng class Bird có thể implement interface IFlyable
        còn class Dog thì không thể. Điều này là do Bird có thể bay, còn Dog thì không thể bay.
        - Như vậy abstract class có thể coi là cha cho tất cả các class con có cùng bản chất với nó.
        - Còn Interface là một chức năng có thể thêm vào bất kỳ vào class nào
        - 2 class Plane và Bird có bản chất hoàn toàn khác nhau nhưng mà đều có thể bay, vì vậy ta có thể implement
        interface IFlyable cho cả 2 class này.
        - Nói ngắn gọn,  quan hệ giữa một class khi thừa kế một abstract class được gọi là is-a,
        và một class khi hiện thực một interface được gọi là can-do
     */

}