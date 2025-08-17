package tips.my2cents.rockpaperscissors

fun main() {
    println("Please enter a number:")
    var inputStringRaw = readln()
    var inputNumber = inputStringRaw.toInt()
    val multiplier = 5
    var result = inputNumber + multiplier
    println("Result of operation is: $result")


}