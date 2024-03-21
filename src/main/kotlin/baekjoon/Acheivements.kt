package baekjoon

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var practiced: Int
    var paid: Int
    do {
        practiced = sc.nextInt()
    } while (sc.hasNextInt() && practiced !in 0..100000)
    do {
        paid = sc.nextInt()
    } while (sc.hasNextInt() && paid !in 0..100000)
    sc.nextLine()

    val actualDays = IntArray(practiced)
    for (i in 0 until practiced) {
        if (sc.hasNextInt()) {
            do {
                actualDays[i] = sc.nextInt()
            } while (actualDays[i] !in 0..1000000)
        }
    }
    sc.close()

    fun findLongestStreak(practiced: Int, paid: Int, actualDays: IntArray): Int {
        var longestStreakLength = 0//최대 길이
        var startPoint = 0//비교 시작지점
        for (i in 0 until practiced - 1) {
            var currentStreakLength = actualDays[i + 1] - actualDays[startPoint] + 1 //지불 여부 상관없이 연속일 수
            var paidDays = minOf(currentStreakLength - 2, paid)//실제 지불한 일 수 , paid가 최대임으로 minOf를 통해 구함
            currentStreakLength -= paidDays // 지불일수를 제외한 연속 일 수
            if (actualDays[i + 1] - actualDays[i] > paid) {
                startPoint = i
            } else {
                longestStreakLength = maxOf(longestStreakLength, currentStreakLength + paid - 1)
            }
        }
        return longestStreakLength
    }
    println(findLongestStreak(practiced, paid, actualDays))
}