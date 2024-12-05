class Rectangle(private val width: Double, private val height: Double) : Shape() {
    override fun calculateArea(): Double = width * height
    override fun calculatePerimeter(): Double = 2 * (width + height)
}