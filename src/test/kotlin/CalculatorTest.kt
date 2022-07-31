import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CalculatorTest {
    var calculator = Calculator()
    val productList = listOf(Product('A', 50), Product('B', 60), Product('C', 25))
    var singleDiscountList1 = listOf(Discounts("AAA", listOf('A', 'A', 'A'), 50))
    var singleDiscountList2 = listOf(Discounts("AA", listOf('A', 'A'), 25))
    var singleDiscountList3 = listOf(Discounts("ABC", listOf('A', 'B', 'C'), 25))
    var singleDiscountList4 = listOf(Discounts("ABB", listOf('A', 'B', 'B'), 50))
    var singleDiscountList5 = listOf(Discounts("AB", listOf('A', 'B'), 10))
    var singleDiscountList6 = listOf(Discounts("EB", listOf('E', 'B'), 5))

    var singleProductsList1 = listOf('A', 'A', 'A')
    var singleProductsList2 = listOf('A', 'A', 'A', 'A')
    var singleProductsList3 = listOf('A', 'B', 'C')
    var singleProductsList4 = listOf('A', 'B', 'C', 'A')
    var singleProductsList5 = listOf('A', 'B', 'B')
    var singleProductsList6 = listOf('A', 'B', 'B', 'A')
    var singleProductsList7 = listOf('E', 'E', 'E', 'E')


    var transaction1 = Transaction(productList, singleDiscountList1, singleProductsList1)
    var transaction2 = Transaction(productList, singleDiscountList2, singleProductsList1)
    var transaction3 = Transaction(productList, singleDiscountList2, singleProductsList2)
    var transaction4 = Transaction(productList, singleDiscountList3, singleProductsList3)
    var transaction5 = Transaction(productList, singleDiscountList4, singleProductsList4)
    var transaction6 = Transaction(productList, singleDiscountList4, singleProductsList5)
    var transaction7 = Transaction(productList, singleDiscountList5, singleProductsList6)
    var transaction8 = Transaction(productList, singleDiscountList5, singleProductsList6)
    var transaction9 = Transaction(productList, singleDiscountList6, singleProductsList7)


    @Test
    fun `calculateValueWithoutDiscount should calculateValue different types of list`() {

        var result1 = calculator.calculateValueWithoutDiscount(transaction1)
        var result2 = calculator.calculateValueWithoutDiscount(transaction2)
        var result3 = calculator.calculateValueWithoutDiscount(transaction3)
        var result4 = calculator.calculateValueWithoutDiscount(transaction4)
        var result5 = calculator.calculateValueWithoutDiscount(transaction5)
        var result6 = calculator.calculateValueWithoutDiscount(transaction6)
        var result7 = calculator.calculateValueWithoutDiscount(transaction7)
        var result8 = calculator.calculateValueWithoutDiscount(transaction8)
        var result9 = calculator.calculateValueWithoutDiscount(transaction9)

        assertEquals(150, result1)
        assertEquals(150, result2)
        assertEquals(200, result3)
        assertEquals(135, result4)
        assertEquals(185, result5)
        assertEquals(170, result6)
        assertEquals(220, result7)
        assertEquals(220, result8)
        assertEquals(0, result9)

    }

    @Test
    fun `calculateDiscountValue should calculateValue a single discount`() {

        var result1 = calculator.calculateDiscountValue(transaction1)
        var result2 = calculator.calculateDiscountValue(transaction2)
        var result3 = calculator.calculateDiscountValue(transaction3)
        var result4 = calculator.calculateDiscountValue(transaction4)
        var result5 = calculator.calculateDiscountValue(transaction5)
        var result6 = calculator.calculateDiscountValue(transaction6)
        var result7 = calculator.calculateDiscountValue(transaction7)
        var result8 = calculator.calculateDiscountValue(transaction8)
        var result9 = calculator.calculateDiscountValue(transaction9)

        assertEquals(50, result1)
        assertEquals(25, result2)
        assertEquals(50, result3)
        assertEquals(25, result4)
        assertEquals(0, result5)
        assertEquals(50, result6)
        assertEquals(20, result7)
        assertEquals(20, result8)
        assertEquals(0, result9)

    }

    @Test
    fun `calculateDiscountValue should calculateValue several discounts`() {
        var discountList = listOf(Discounts("AAA", listOf('A', 'A', 'A'), 50), Discounts("AB", listOf('A', 'B'), 25))
        var purcharsedList = listOf('A', 'A', 'A', 'A', 'A', 'B', 'A', 'A', 'A')
        var transaction = Transaction(productList, discountList, purcharsedList)

        var result = calculator.calculateDiscountValue(transaction)

        assertEquals(125, result)
    }

    @Test
    fun `calculateDiscountValue should prioritize best discounts`() {
        var discountList = listOf(Discounts("AAA", listOf('A', 'A', 'A'), 25), Discounts("AB", listOf('A', 'B'), 50))
        var purchaseList = listOf('A', 'A', 'A', 'B', 'B', 'B', 'A')
        var transaction = Transaction(productList, discountList, purchaseList)

        var result = calculator.calculateDiscountValue(transaction)

        assertEquals(150, result)
    }
}