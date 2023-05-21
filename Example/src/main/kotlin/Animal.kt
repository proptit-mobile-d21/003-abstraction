abstract class Animal(name: String){
    protected abstract val legs: Int
    protected abstract val type: String

    init {
        println("Found a $type")
    }

    abstract fun showName()

    final fun isMove(){
        println("It is moving with $legs legs")
    }

}