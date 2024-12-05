import kotlin.math.sqrt

class Triangle(private val a: Double, private val b: Double, private val c: Double) : Shape() {
    override fun calculateArea(): Double {
        val s = (a + b + c) / 2 // Полупериметр
        return sqrt(s * (s - a) * (s - b) * (s - c)) // Формула Герона
    }

    override fun calculatePerimeter(): Double = a + b + c
}