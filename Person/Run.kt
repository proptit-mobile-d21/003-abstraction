fun main() {
    val designer = Designer("Trung")
    val developer = Developer("HoLa")

    println(designer.name)
    designer.Show()
    designer.Action()

    println(developer.name)
    developer.Show()
    developer.Action()
}
