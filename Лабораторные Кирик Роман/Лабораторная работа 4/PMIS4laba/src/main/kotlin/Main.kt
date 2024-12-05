fun main() {
    val shapes: List<Shape> = listOf(
        Circle(5.0),
        Rectangle(4.0, 6.0),
        Triangle(3.0, 4.0, 5.0)
    )

    val adapters: List<ShapeAdapter> = shapes.map { ShapeAdapterImpl(it) }

    adapters.forEach { adapter ->
        println("Area: ${adapter.getArea()}, Perimeter: ${adapter.getPerimeter()}")
    }
}