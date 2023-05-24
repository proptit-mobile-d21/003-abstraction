
abstract class Animal(){
    abstract fun sound()
}
interface RunAble{
    fun Run()
}
interface SwimAble{
    fun swim()
}
class Dog : Animal(),RunAble{ // dog thuộc lớp động vật và kế thừa những đặc điểm của động vật và có thể chạy
    override fun sound() {
        println("gau gau")
    }

    override fun Run() {
        println("can run")
    }
}
class Duck: Animal(),SwimAble{ // vịt thuộc lớp động vật và kế thừa những đặc điểm của động vật và có thể bơi
    override fun sound() {
        println("Quac quac")
    }

    override fun swim() {
        println("can swim")
    }

}
class Cat : Animal(),RunAble{ // mèo thuộc lớp động vật và kế thừa những đặc điểm của động vật và có thể chạy
    override fun sound() {
        println("meow meow")
    }

    override fun Run() {
        println("can run")
    }
}
fun main(args: Array<String>) {
    val dog = Dog()
    dog.sound()
    dog.Run()
    val duck = Duck()
    duck.sound()
    duck.swim()
    val cat = Cat()
    cat.sound()
    cat.Run()

}

//Abstract classes should be used primarily for objects that are closely related, whereas interfaces are best suited for
// providing a common functionality to unrelated classes


//Cần sử dụng tính abstract:
//- Để đảm bảo tính bảo mật và chỉ hiển thị những thông tin cần thiết cho người sử dụng
//- Thống nhất các class có đặc điểm giống nhau => code ngắn gọn, đơn giản, tái sử dụng code