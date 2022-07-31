interface ICalculator {
    fun calculateValueWithoutDiscount(transaction: Transaction): Int
    fun calculateDiscountValue(transaction: Transaction): Int
}

class Calculator() : ICalculator {
    override fun calculateValueWithoutDiscount(transaction: Transaction): Int {
        return transaction.productList.sumOf { product -> transaction.shoppingList.count { it == product.name } * product.price }
    }

    override fun calculateDiscountValue(transaction: Transaction): Int {
        var myshoppingList: MutableList<Char> = transaction.shoppingList.toMutableList()
        var totalDiscount = 0


        transaction.discountsList.sortedByDescending { product -> product.priceDiscount }.forEach() { discount ->

            var pairCountedOcurrencesOfEachCode = calculateOccurrencesOfEachCode(discount, myshoppingList)

            if (validateKeyOccurrence(pairCountedOcurrencesOfEachCode)) {

                var numberOfTimesDiscountApplied =
                    calculateAmountOfTimesDiscountCanBeApplied(pairCountedOcurrencesOfEachCode)

                pairCountedOcurrencesOfEachCode.forEach { pair ->

                    repeat(numberOfTimesDiscountApplied * pair.value) {
                        myshoppingList.remove(
                            pair.key.first
                        )
                    }
                }
                totalDiscount += numberOfTimesDiscountApplied * discount.priceDiscount
            }
        }
        return totalDiscount
    }
}

private fun calculateAmountOfTimesDiscountCanBeApplied(pairCountedOcurrencesOfEachCode: Map<Pair<Char, Int?>, Int>): Int {
    return pairCountedOcurrencesOfEachCode.map { it.key.second?.div(it.value) ?: 0 }.min()
}

private fun validateKeyOccurrence(pairCountedOcurrencesOfEachCode: Map<Pair<Char, Int?>, Int>): Boolean {
    return pairCountedOcurrencesOfEachCode.keys.all { x -> x.second != 0 }
}

private fun calculateOccurrencesOfEachCode(
    discount: Discounts,
    myshoppingList: MutableList<Char>
): Map<Pair<Char, Int?>, Int> {
    return discount.products.map { product ->
        product to myshoppingList.groupingBy { it }.eachCount().get(product)
    }.groupingBy { it }.eachCount()
}