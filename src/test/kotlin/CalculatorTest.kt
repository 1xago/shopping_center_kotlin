import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CalculatorTest {

    @Test
    fun `calculateValueWithoutDiscount should calculateValue different types of list`() {
        var calculator = Calculator()
        val productList = listOf(Product('A', 50), Product('B', 60), Product('C', 25))
        var shoppingList1 = listOf('A', 'A', 'A')
        var shoppingList2 = listOf('A', 'B', 'C')
        var shoppingList3 = listOf('E', 'E', 'E')
        var discountList = listOf(Discounts("AAA", listOf('A', 'A', 'A'), 50))

        var transaction1 = Transaction(productList, discountList, shoppingList1)
        var transaction2 = Transaction(productList, discountList, shoppingList2)
        var transaction3 = Transaction(productList, discountList, shoppingList3)

        var result1 = calculator.calculateValueWithoutDiscount(transaction1)
        var result2 = calculator.calculateValueWithoutDiscount(transaction2)
        var result3 = calculator.calculateValueWithoutDiscount(transaction3)

        assertEquals(150, result1)
        assertEquals(135, result2)
        assertEquals(0, result3)

    }
}