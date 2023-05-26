### **1. Lấy ví dụ làm rõ tính abstract của lập trình hướng đối tượng.**
- Abstract: 
    ```kotlin
    interface Drawable {
        fun draw()
    }

    class Circle : Drawable {
        override fun draw() {
            println("Drawing a circle")
        }
    }

    class Square : Drawable {
        override fun draw() {
            println("Drawing a square")
        }
    }

    fun main() {
        val circle = Circle()
        circle.draw()

        val square = Square()
        square.draw()
    }
    ```

### **2. Lấy ví dụ làm rõ tác dụng của interface và abstract class.**

- Interface
    ```kotlin
    interface Workable{
        fun calSalary(dayWorked: Int, daySalary: Double) : Double
    }

    interface Fix{
        fun fixComputer()
    }

    private class Dev :Workable, Fix{
        override fun calSalary(dayWorked : Int, daySalary : Double) : Double{
            return dayWorked * daySalary
        }

        override fun fixComputer() {
            println("Dev fixs the computer.")
        }
    }

    fun main(){
        val dev = Dev()
        println("Salary: ${String.format("%.1f", dev.calSalary(20, 100.0))}")
        dev.fixComputer()
    }
    ```

- Abstract class:
    ```kotlin
    abstract class Person(val name : String, val age : Int, val height : Double, val weight : Double){
        internal fun calBMI() : Double {
            return weight/(height * height)
        }

        abstract fun calSalary(dayWorked: Int, daySalary : Double) : Double
    }

    class Dev(name: String, age: Int, height: Double, weight: Double) : Person(name, age, height, weight){
        override fun calSalary(dayWorked: Int, daySalary : Double) : Double{
            return dayWorked * daySalary
        }
    }

    fun main(){
        val dev = Dev("Thuy", 18, 1.53, 42.0)
        println("BMI: ${String.format("%.1f", dev.calBMI())}")
        println("Salary: ${String.format("%.1f", dev.calSalary(20, 100.0))}")
    }
    ```

### **3. Lấy ví dụ phân biệt sự khác biệt giữa interface và abstract class.**

- Từ ví dụ ở câu 2, ta có thể thấy một số khác biệt giữa interface và abstract class như sau:

| Interface | Abstract Class |
| - | - |
| Một class có thể implement nhiều interfaces. | Một class chỉ có thể extend một abstract class. |
| Không thể tạo constructors, init blocks. | Có thể tạo constructors, init blocks. 
| Chỉ có `public`, không có các access modifiers khác. | Có access modifiers. |



### **4. Từ 3 ví dụ trên trả lời câu hỏi tại sao cần sử dụng tính abstract.**

- Thay vì ta cho users biết chi tiết ***properties***, ***functions***, cách thức hoạt động của một object thì ta đưa cho user cách sử dụng một object hoàn chỉnh mà không cần quan tâm những cái bên trong nó xảy ra như nào. 

- Ứng dụng trong phát triển phần mềm:  Khi developers muốn xây dựng API/librabries thì họ chỉ cần cung cấp interface đơn giản rõ ràng cho những dev khác sử dụng và ẩn đi những thứ phức tạp ở đằng sau.

### **5. Tìm hiểu sealed class.**

- `Sealed` classes tương tự với `enum` classes nhưng thay vì enum constants thì `sealed` classes chứa các ***subclasses (***là các ***nested class*** được khai báo bên trong ***`sealed`*** class đó***).***
- Syntax:

    ```kotlin
    sealed class SealedClass{
        class subClass1 : SealedClass()
        class subClass2 : SealedClass()
    }
    ```

- `sealed` class là `abstract` nên không thể tạo ***instance*** được.
- Constructor của `sealed` class thì `protected` by default và có thể `private` (không thể `public` or `internal`)
- Tất cả các ***subclasses*** của `sealed` class đều phải khai báo trong cùng 1 file.

### **6. Phân biệt sealed class và enum.**

- `enum` class: tất cả các ***enum constants*** đều cùng một kiểu, các functions của các ***enum constants*** cũng phải giống nhau.
    
    ```kotlin
    enum class Fruit(val color : String) {
        WATERMELON("Red"),
        JACKFRUIT("Yellow"),
        MANGOSTEEN(12) // error
    }
    ```
    
- `sealed` class:  các ***subclasses*** có thể có khởi tạo khác nhau, mỗi **subclasses** có thể có các ***functions*** của riêng nó. (Nôm na: `sealed` = `enum` + `abstract` classes)
    
    ```kotlin
    sealed class Fruit {
        class Watermelon(color : String) : Fruit()
        class Jackfruit(number : Int) : Fruit()
        class Mangosteen(color : String, number : Int)  : Fruit()
    }
    ```

### **7. Phân biệt sealed class và inner class.**
- `sealeds` class và `inner` class đều là class nằm trong một class khác và đều có thể truy cập đến các ***properties*** của class chứa nó.

- `sealed` class là subclass của class chứa nó, còn `inner` thì không phải.  
=> Vì vậy mà `sealed` class không thể truy cập đến phần tử `private` của parent class, trong khi `inner` class có thể truy cập đến phần tử `private` của outer class.

- Cách tạo instance của `sealed` class: 
    ```kotlin
    sealed class SealedClass{
        val number : Int = 10
        class SubClass1 : SealedClass(){
            fun getNum() = number
        }
        class SubClass2 : SealedClass()
    }

    fun main(){
        val sealedClass : Int = SealedClass.SubClass1().getNum()
        println(sealedClass) // 10
    }
    ```

- Cách tạo instance của `inner` class:

    ```kotlin
    class Outer {
        private val bar: Int = 1

        inner class Inner {
            fun foo() = bar
        }
    }
    val demo = Outer().Inner().foo() // == 1
    ```
### **8. Tại sao cần sử dụng sealed class.**
- Nếu ta muốn có một số ***constants*** có sự liên quan đến nhau, tuy nhiên mỗi ***constant*** lưu trữ data và implements các ***functions*** khác nhau thì ta cần dùng đến `sealed` class.
- Khi dùng `when` với `sealed` class thì compiler sẽ kiểm tra xem `when` của mình đã xét hết các trường hợp ***subclasses*** của `sealed` class chưa, nếu chưa sẽ báo lỗi.
- Giúp kiểm soát việc class nào có thể inherit từ `sealed` class, mình cũng có thể biết tất cả các trường hợp của ***subclasses*** và không có trường hợp nào ngoại lệ.