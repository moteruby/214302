fun main(args: Array<String>) {
    val arr = intArrayOf(1, 2, 3, 2, -2, 6, -1, -5, 3)
    val targetSum = 6

    val subarrays = findSubarraysWithSum(arr, targetSum)

    if (subarrays.isNotEmpty()) {
        println("Подмассивы с суммой $targetSum:")
        for ((start, end) in subarrays) {
            println("С индекса $start до $end (элементы: ${arr.slice(start..end)})")
        }
    } else {
        println("Не найдены подмассивы с суммой $targetSum")
    }
}

fun findSubarraysWithSum(arr: IntArray, targetSum: Int): List<Pair<Int, Int>> {
    val result = mutableListOf<Pair<Int, Int>>()

    for (start in arr.indices) {
        var currentSum = 0
        for (end in start until arr.size) {
            currentSum += arr[end]

            if (currentSum == targetSum) {
                result.add(Pair(start, end))
            }
        }
    }
    return result
}

