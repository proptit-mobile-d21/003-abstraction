

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

    /*
    + Tại sao phải sử dụng Abstract Class:
        - Ta sử dụng Abstract Class để có thể tạo ra 1 Class với các đặc điểm, thuộc tính chung áp dụng với các Class con khác giúp code gọn gàng, đơn giản hơn.
        - Tái sử dụng lại các đoạn code.
    + Tại sao phải sử dụng Sealed Class:
        - Khi ta muốn giới hạn các subclass và điều khiển chúng dễ dàng.
        - Tăng tính an toàn vì sealed class cung cấp tính an toàn kiểu dữ liệu tốt hơn so với kế thừa, cho phép compiler biết toàn bộ các lớp con và kiểm soát dễ hơn.
        - Xử lý toàn bộ trường hợp bằng when expression -> giúp phát hiện các trường hợp còn thiếu và tránh lỗi.
     */
}