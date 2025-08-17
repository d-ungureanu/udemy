package tips.my2cents.kotlinbasics

class Dog(val name: String, val breed: String) {

    init {
        bark(name)
    }

    fun bark(name: String) {
        println("$name says Woof Woof!")
    }
}