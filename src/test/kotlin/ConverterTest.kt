import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


internal class ConverterTest {
    var converter = Converter()

    @Test
    fun `convert should return the value in pounds`() {
        var result1 = converter.convert(0)
        var result2 = converter.convert(10)
        var result3 = converter.convert(14)
        var result4 = converter.convert(-20)

        assertEquals("0£", result1)
        assertEquals("0.1£", result2)
        assertEquals("0.14£", result3)
        assertEquals("0£", result4)
    }
}