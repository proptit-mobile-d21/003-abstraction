package com.example.test

import java.text.DecimalFormat


abstract class Shape(private val nameShape: String) {
    abstract fun calculateArea(): Double
    fun displayArea() {
        println("Area of $nameShape is: ${DecimalFormat("#.##").format(calculateArea())}")
    }
}

class Circle(private val radius: Double) : Shape("Circle") {
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
}

class Rectangle(private val width: Double, private val length: Double) : Shape("Rectangle") {
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
