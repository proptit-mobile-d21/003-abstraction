package com.example.test

import java.text.DecimalFormat

// Abstract class shape đại diện cho các hình học
abstract class Shape(private val nameShape: String) {   // Hàm khởi tạo truyền vào tên hình học
    // Phương thức trừu tượng tính diện tích
    abstract fun calculateArea(): Double

    // Phương thức thông báo ra màn hình diện tích của hình
    fun displayArea() {
        println("Area of $nameShape is: ${DecimalFormat("#.##").format(calculateArea())}")
    }
}

// Lớp con Circle triển khai lớp Shape
class Circle(private val radius: Double) : Shape("Circle") {
    // override lại hàm tính diện tích
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

// Lớp con Rectangle triển khai lớp Shape
class Rectangle(private val width: Double, private val length: Double) : Shape("Rectangle") {
    // override lại hàm tính diện tích
    override fun calculateArea(): Double {
        return width * length
    }
}

fun main() {
    val circle = Circle(2.0)
    val rectangle = Rectangle(4.0, 5.0)

    circle.displayArea()
    rectangle.displayArea()
}
