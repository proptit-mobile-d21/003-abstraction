1. Lấy ví dụ làm rõ tính abstract của lập trình hướng đối tượng.
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

2. Lấy ví dụ làm rõ tác dụng của interface và abstract class.

3. Lấy ví dụ phân biệt sự khác biệt giữa interface và abstract class.

4. Từ 3 ví dụ trên trả lời câu hỏi tại sao cần sử dụng tính abstract.

5. Tìm hiểu sealed class.

6. Phân biệt sealed class và enum.

7. Phân biệt sealed class và inner class.

8. Tại sao cần sử dụng sealed class.