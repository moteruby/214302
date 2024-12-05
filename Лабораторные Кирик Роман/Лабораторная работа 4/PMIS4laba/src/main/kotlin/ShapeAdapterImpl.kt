class ShapeAdapterImpl(private val shape: Shape) : ShapeAdapter {
    override fun getArea(): Double = shape.calculateArea()
    override fun getPerimeter(): Double = shape.calculatePerimeter()
}