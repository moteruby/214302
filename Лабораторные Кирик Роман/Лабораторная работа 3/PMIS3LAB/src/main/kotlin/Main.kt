import kotlin.math.*

fun <T, R> cachedCalculation(calculation: (T) -> R): (T) -> R {
    val cache = mutableMapOf<T, R>()

    return { input: T ->
        if (input in cache) {
            println("Результат для $input взят из кэша.")
            cache[input]!!
        } else {
            println("Выполнение вычислений для $input.")
            val result = calculation(input)
            cache[input] = result
            result
        }
    }
}

val factorialCache = mutableMapOf<Int, Long>()

fun factorial(n: Int): Long {
    return factorialCache.getOrPut(n) {
        if (n <= 1) 1 else  n * factorial(n - 1)
    }
}

fun complexExpression(x: Double, n: Int): Double {
    return (1..n).sumOf { it ->
        val term1 = factorial(it) * sin(x / it)
        val term2 = cos(it * x) / (1 + ln(it.toDouble()))
        val term3 = exp(-it * x / n)
        (term1 + term2) * term3
    }
}

fun main() {
    val cachedComplexExpression: ((Pair<Double, Int>) -> Double) = cachedCalculation { (x, n) ->
        complexExpression(x, n)
    }

    val x = 3.14
    val n = 10

    println("Результат: ${cachedComplexExpression(x to n)}")

    println("Результат: ${cachedComplexExpression(x to n)}")

    println("Результат: ${cachedComplexExpression(2.71 to n)}")

    println("Результат: ${cachedComplexExpression(2.71 to n)}")
}
