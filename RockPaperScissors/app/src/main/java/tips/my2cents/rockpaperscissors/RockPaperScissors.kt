package tips.my2cents.rockpaperscissors

fun main() {
    val possibleChoices = arrayOf("Rock", "Paper", "Scissors")
    val exitCommand = "exit"



    while (true) {
        var playerChoice: String

        while (true) {
            print("Rock, Paper, Scissors? \nPlayer's choice: ")
            playerChoice = readln().trim()
            if (playerChoice == exitCommand) {
                println("Game over!")
                return
            }
            if (playerChoice in possibleChoices) break
            println("Invalid choice, please try again!")
        }
        val randomNumber = (0..2).random()
        var choicesList = arrayListOf("Rock", "Paper", "Scissors")
        var computerChoice = choicesList[randomNumber]
        println("Computer's choice: $computerChoice")
        val winner = when {
            playerChoice == computerChoice -> "Tie"
            playerChoice == "Rock" && computerChoice == "Scissors" -> "Player"
            playerChoice == "Paper" && computerChoice == "Rock" -> "Player"
            playerChoice == "Scissors" && computerChoice == "Paper" -> "Player"
            else -> {
                "Computer"
            }
        }

        if (winner == "Tie") {
            println("No one won, it was a $winner")
        } else {
            println("Winner: $winner")
        }
        println("=============================================")
    }

}