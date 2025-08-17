package tips.my2cents.kotlinbasics

fun main() {
    val shoppingList = mutableListOf("Processor", "AirCooler", "RAM", "SSD", "Rtx5090Ti")
    println(shoppingList)
    val hasRam = shoppingList.contains("RAM")
//    println(hasRam)

    for (index in 0 until shoppingList.size){
        println(shoppingList[index])
    }

}
