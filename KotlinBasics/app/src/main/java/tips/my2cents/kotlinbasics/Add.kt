package tips.my2cents.kotlinbasics

fun main() {
    println("Please input number 1:")
    val number1 = readln().toInt()
    println("Please input number 2:")
    val number2 = readln().toInt()
    val sumOfNumbers = add(number1, number2)
    println("Sum: $sumOfNumbers")
}

fun add(number1: Int, number2: Int): Int {
    return number1 + number2
}