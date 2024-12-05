import kotlin.math.PI

class Circle(private val radius: Double) : Shape() {
    override fun calculateArea(): Double = PI * radius * radius
    override fun calculatePerimeter(): Double = 2 * PI * radius
}