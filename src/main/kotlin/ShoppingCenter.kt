class ShoppingCenter(val converter: IConverter, val calculator: ICalculator) {

    fun processTransaction(transaction: Transaction): Int {
        var totalWithoutDiscount = calculator.calculateValueWithoutDiscount(transaction)
        var total = totalWithoutDiscount
        printTransaction(transaction)
        println("total price without discount = ${converter.convert(totalWithoutDiscount)}")
        println("total price  = ${converter.convert(total)}")
        return total
    }

    private fun printTransaction(transaction: Transaction) {
        transaction.shoppingList.forEach { product -> println("${product} at price of ${converter.convert(transaction.productList.first { it.name == product }.price)}") }
    }

    companion object {
        fun start(converter: Converter, calculator: Calculator) = ShoppingCenter(converter, calculator)

    }
}