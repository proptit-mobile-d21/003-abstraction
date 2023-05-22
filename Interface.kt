package Mobile_003

// Sử dụng Interface
interface Person_Int {
    var name: String
    var age: Int
    fun setName() {
        print("Enter name: ")
        name = scanner.nextLine()
    }
    fun setAge(){
        print("How old are you? ")
        age = scanner.nextLine().toInt()
    }
    fun displayDetails()
}

class Student_Int : Person_Int {
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

class Employee_Int : Person_Int {
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
    val student: Person_Int = Student_Int()
    println("Student: ")
    student.setName()
    student.setAge()
    (student as Student_Int).setStudentID()
    (student as Student_Int).setShoolYear()
    student.displayDetails()

    val employee: Person_Int = Employee_Int()
    println("Employee: ")
    employee.setName()
    employee.setAge()
    (employee as Employee_Int).setEmployeeID()
    (employee as Employee_Int).setPosition()
    employee.displayDetails()
}