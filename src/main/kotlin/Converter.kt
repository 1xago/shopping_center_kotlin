interface IConverter {
    fun convert(price: Int): String
}


class Converter() : IConverter {

    override fun convert(price: Int): String {
        return if (price <= 0) "0£" else ((price.toDouble()) / 100).toString() + "£"
    }

}