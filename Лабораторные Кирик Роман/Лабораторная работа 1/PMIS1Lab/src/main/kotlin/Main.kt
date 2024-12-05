fun main() {
    while(true) {
        println("������� ���� � ������� dd.MM.yyyy:")
        val input = readLine()

        if (input.isNullOrBlank()) {
            println("������������ ����.")
            return
        }

        val parts = input.split(".")
        if (parts.size != 3) {
            println("�������� ������ ����. ����������� ������ dd.MM.yyyy")
            return
        }

        val day = parts[0].toIntOrNull()
        val month = parts[1].toIntOrNull()
        val year = parts[2].toIntOrNull()

        if (day == null || month == null || year == null) {
            println("�������� ������ ����. ��� ����� ������ ���� �������.")
            return
        }

        if (!isValidDate(day, month, year)) {
            println("������������ ����.")
            return
        }

        val dayOfWeek = getDayOfWeek(day, month, year)
        val dayOfWeekName = getDayOfWeekName(dayOfWeek)

        val season = getSeason(month)

        println("���� ������: $dayOfWeekName")
        println("����� ����: $season")
    }
}

fun isValidDate(day: Int, month: Int, year: Int): Boolean {
    if (month < 1 || month > 12) return false
    if (day < 1) return false

    val daysInMonth = when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if (isLeapYear(year)) 29 else 28
        else -> return false
    }

    return day <= daysInMonth
}

fun getDayOfWeek(day: Int, month: Int, year: Int): Int {
    var adjustedYear = year
    var adjustedMonth = month

    if (month < 3) {
        adjustedYear--
        adjustedMonth += 10
    } else {
        adjustedMonth -= 2
    }

    val result = (day + 31 * adjustedMonth / 12 + adjustedYear + adjustedYear / 4 - adjustedYear / 100 + adjustedYear / 400) % 7
    return if (result < 0) result + 7 else result
}

fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

fun daysInMonth(month: Int, year: Int): Int {
    return when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if (isLeapYear(year)) 29 else 28
        else -> throw java.lang.Exception("������")
    }
}

fun getDayOfWeekName(dayOfWeek: Int): String {
    return when (dayOfWeek) {
        0 -> "�����������"
        1 -> "�����������"
        2 -> "�������"
        3 -> "�����"
        4 -> "�������"
        5 -> "�������"
        6 -> "�������"
        else -> "�����������"
    }
}

fun getSeason(month: Int): String {
    return when (month) {
        12, 1, 2 -> "����"
        3, 4, 5 -> "�����"
        6, 7, 8 -> "����"
        9, 10, 11 -> "�����"
        else -> "�����������"
    }
}