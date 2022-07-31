fun main(args: Array<String>) {
    println("Hello World!")

    var converter = Converter()
    converter.convert(0)

    val productList = listOf(Product('A', 50), Product('B', 60), Product('C', 25))
    var discountList =
        listOf(Discounts("AAA discount", listOf('C', 'B', 'B'), 50), Discounts("AAA d", listOf('A', 'A', 'A'), 40))
    var purchasedProducts = listOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'B', 'B')
    var transaction = Transaction(productList, discountList, purchasedProducts)

    var calculator = Calculator()
    var calculation = calculator.calculateValueWithoutDiscount(transaction)
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("total cost =: ${calculation}")
}