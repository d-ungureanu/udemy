package tips.my2cents.bankaccountprogram



fun main() {
    val danielsAccount = BankAccount("Daniel Ungureanu", 3000.00)
    println("Original balance: ${danielsAccount.balance}")

    danielsAccount.deposit(200.00)
    danielsAccount.withdraw(1200.00)
    danielsAccount.deposit(3000.00)
    danielsAccount.deposit(2000.00)
    danielsAccount.withdraw(3333.15)


    danielsAccount.displayTransactionHistory()

    println(danielsAccount.accBalance())

}