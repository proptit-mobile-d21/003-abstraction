package com.example.test

import java.text.DecimalFormat

// Tạo 1 interface gia đình
interface Family {
    // Gồm abstract tên cha và mẹ
    val fatherName: String
    val motherName: String

    // Hàm hiển thị thông tin cha mẹ được triển khai
    fun showFamily() {
        println("Father name is: $fatherName")
        println("Mother name is: $motherName")
    }
}

// Interface trường học
interface School {
    // Gồm abstract điểm 3 môn
    val math: Double
    val physical: Double
    val chemistry: Double

    // Hàm hiển thị điểm được triển khai
    fun showScore() {
        println("Math score is: $math")
        println("Physical score is: $physical")
        println("Chemistry score is: $chemistry")
        println("Average score is: ${DecimalFormat("#.##").format((math + physical + chemistry) / 3)}")
    }
}

// Một class person kế thừa 2 interface là Family và School
class Person(
    private val namePerson: String,
    father: String,
    mother: String,
    m: Double,
    p: Double,
    c: Double
) : Family, School {
    // Override lại các thuộc tính bằng cách gán nó với thuộc tính truyền vào ở constructor
    override val fatherName: String = father
    override val motherName: String = mother

    override val math: Double = m
    override val physical: Double = p
    override val chemistry: Double = c

    // Override lại hàm show: gọi lại hàm show cũ và thêm hiển thị tên của person
    override fun showFamily() {
        super.showFamily()
        println("Person name is: $namePerson")
    }
}

fun main() {
    val person = Person("Tel", "Yorn", "Lily", 9.2, 9.0, 8.8)
    person.showFamily()
    person.showScore()
}
