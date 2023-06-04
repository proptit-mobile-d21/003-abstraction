// Su khac nhau giua interface va abstract class

interface Parents{
    val motherName: String
    val fatherName: String
    fun showParentsInfo()
}

interface Occupation{
    fun showInfo(job: String)
}

class Person1(
    private val name: String,
    private val age: Int,
    mother: String,
    father: String
    ): Parents, Occupation{  // 1 class implement nhieu interfaces
    override val motherName = mother
    override val fatherName = father
    override fun showParentsInfo() {
        println("$name's mother is $motherName")
        println("$name's father is $fatherName")
    }

    override fun showInfo(job: String) {
        println("$name is a/an $job")
        println("He/She is $age years old")
    }
}

// abstract class co constructor
abstract class Teacher(val name: String, val age: Int)
{
    val job = "Teacher" //khoi tao duoc state cho property
    //co access modifiers
    internal fun showInfo(){
        println("$name is a/an $job")
        println("He/She is $age years old")
    }
    abstract fun subjectSpecialization(subject:String)
}

class mathTeacher(name: String, age: Int) : Teacher(name, age){
    override fun subjectSpecialization(subject: String) {
        println("He's specialized in teaching $subject")
    }

}


fun main()
{
    val person1 = Person1("Jane", 25, "Bob", "Jen")
    person1.showParentsInfo()
    person1.showInfo("Teacher")
    val teacher1 = mathTeacher("Kai", 52)
    teacher1.showInfo()
    teacher1.subjectSpecialization("Mathematics")
}
