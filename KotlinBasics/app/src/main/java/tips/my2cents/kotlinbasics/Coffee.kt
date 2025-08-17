package tips.my2cents.kotlinbasics

fun main() {
    println("Who is the coffee for?")
    var name = readln()
    println("Any sugar?")
    var sugarCount =readln().toInt()


    makeCoffee(0, name)
}

fun makeCoffee(sugarCount: Int, name: String) {
    var sugarMessage: String
    when (sugarCount) {
        0 -> sugarMessage = "no"
        1 -> sugarMessage = "1 teaspoon of"
        else -> sugarMessage = "$sugarCount teaspoons of"
    }
    println("Coffee with $sugarMessage sugar for $name.")
}