package tips.my2cents.kotlinbasics

fun main() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    println(numbers)
    for (index in 0 until numbers.size) {
//        println("item ${numbers[index]} is at index $index")
        numbers[index] = numbers[index] * 2
    }

    println(numbers)
}