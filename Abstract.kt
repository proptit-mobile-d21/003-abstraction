package Mobile_003
import java.util.Scanner

//Sử dụng Abstract class
val scanner = Scanner(System.`in`)
abstract class Person_Abs {
    abstract var name: String
    abstract var age: Int
    fun setName() {
        print("Enter name: ")
        name = scanner.nextLine()
    }
    fun setAge(){
        print("How old are you? ")
        age = scanner.nextLine().toInt()
    }
    abstract fun displayDetails()
}
class Student_Abs : Person_Abs() {
    override var name: String = ""
    override var age: Int = 0
    var studentID: String = ""
    var shoolYear:Int = 0
    fun setStudentID(){
        print("Enter your student ID: ")
        studentID = scanner.nextLine()
    }
    fun setShoolYear(){
        print("Enter your school year: ")
        shoolYear = scanner.nextLine().toInt()
    }
    override fun displayDetails() {
        println("Student name: $name")
        println("Student age: $age")
        println("Student ID: $studentID")
        println("School year: $shoolYear")
        println("---------------------------------")
    }
}
class Employee_Abs : Person_Abs() {
    override var name: String = ""
    override var age: Int = 0
    var employeeID: String = ""
    var position: String = ""
    fun setEmployeeID(){
        print("Enter your employee ID: ")
        employeeID = scanner.nextLine()
    }
    fun setPosition(){
        print("Enter your position: ")
        position = scanner.nextLine()
    }
    override fun displayDetails() {
        println("Employee name: $name")
        println("Employee age: $age")
        println("Employee ID: $employeeID")
        println("Position: $position")
        println("---------------------------------")
    }
}
fun main() {
    val student = Student_Abs()
    student.setName()
    student.setAge()
    student.setStudentID()
    student.setShoolYear()
    student.displayDetails()

    val employee = Employee_Abs()
    employee.setName()
    employee.setAge()
    employee.setEmployeeID()
    employee.setPosition()
    employee.displayDetails()
}