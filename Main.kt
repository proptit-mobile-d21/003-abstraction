//Interface: - abstract member, abstract const, fun but not implementation
// - cannot have init block or constructor
//abstract class: same interface but have constructor and init
// - extend abstract -> need constructor ()
// can only inherit a single class => solve this we use Interface
// Interface: all func are abstract in default

abstract  class test {
    init {

    }
}

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}