@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val d = (number % 10)
    val c = ((number - d) / 10) % 10
    val b = ((number - c * 10 - d) / 100) % 10
    val a = (number - number % 1000) / 1000

    return (a + b == c + d)
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = (x1 == x2 || y1 == y2 || abs(x1 - x2) == abs(y1 - y2))


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    var res = 0

    if (month == 2) {
        when {
            year % 4 != 0 -> res = 28
            year % 100 == 0 && year % 400 != 0 -> res = 28
            else -> res = 29
        }
    } else {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) res =
            31 else {
            if (month == 4 || month == 6 || month == 9 || month == 11) res = 30
        }
    }

    return res
}


/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = sqr(x1 - x2) + sqr(y1 - y2) < sqr(r1 - r2)

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {

    val hMid: Int
    val hMax = max(max(a, b), max(b, c))
    val hMin = min(min(a, b), min(b, c))
    val rMax = max(r, s)
    val rMin = min(r, s)

    if (hMax == a) {
        if (hMin == b) hMid = c else hMid = b
    } else {
        if (hMax == b) {
            if (hMin == c) hMid = a else hMid = c
        } else if (hMin == a) hMid = b else hMid = a
    }

    return ((hMax <= rMax && hMid <= rMin) || (hMid <= rMax && hMin <= rMin))
}
