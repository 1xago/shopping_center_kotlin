fun main(args: Array<String>) {
    println("Hello World!")

    var shoppingCenter = ShoppingCenter.start(Converter(), Calculator())

    val productList = listOf(Product('A', 50), Product('B', 60), Product('C', 25))
    var discountList =
        listOf(Discounts("AAA", listOf('A', 'A', 'A'), 50), Discounts("AAA", listOf('A', 'A', 'A'), 40))
    var purchasedProducts = listOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'B', 'B')

    var transaction = Transaction(productList, discountList, purchasedProducts)
    var result = shoppingCenter.processTransaction(transaction)

    println("total cost = ${result}")
}