package baekjoon

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val p = sc.nextInt()
    val actualDays = IntArray(n) { sc.nextInt() }

    var maxStreak = 0
    var remainPaid = 0
    var start = 0

    for (end in actualDays.indices) {
        if (end > 0) {
            val gap = actualDays[end] - actualDays[end - 1] - 1
            remainPaid += gap
        }


        while (remainPaid > p) {
            val gap = actualDays[start + 1] - actualDays[start] - 1
            remainPaid -= gap
            start++
        }

        maxStreak = maxOf(maxStreak, actualDays[end] - actualDays[start] + 1 + p - remainPaid)
    }

    println(maxStreak)
}