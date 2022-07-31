import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import io.mockk.every
import io.mockk.mockk

internal class ShoppingCenterTest {
    @Test
    fun `should return the value of the transaction`() {
        val productList = listOf(Product('A', 50), Product('B', 60), Product('C', 25))
        var discountList =
            listOf(Discounts("AAA discount", listOf('A', 'A', 'A'), 50), Discounts("AAA", listOf('A', 'A', 'A'), 40))
        var purchasedProducts = listOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'B', 'B')

        val calculator = mockk<ICalculator>()
        every { calculator.calculateValueWithoutDiscount(any()) } returns 5
        every { calculator.calculateDiscountValue(any()) } returns 3

        val converter = mockk<IConverter>()
        every { converter.convert(any()) } returns ""

        var shoppingCenter = ShoppingCenter(converter, calculator)

        assertEquals(2, shoppingCenter.processTransaction(Transaction(productList, discountList, purchasedProducts)))
    }
}