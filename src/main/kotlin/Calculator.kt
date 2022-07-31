interface ICalculator {
    fun calculateValueWithoutDiscount(transaction: Transaction): Int

}

class Calculator() : ICalculator {

    override fun calculateValueWithoutDiscount(transaction: Transaction): Int {
        return transaction.productList.sumOf { product -> transaction.shoppingList.count { it == product.name } * product.price }
    }
}

