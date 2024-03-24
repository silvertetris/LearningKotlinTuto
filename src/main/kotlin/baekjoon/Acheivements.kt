package baekjoon

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    var practiced: Int
    var paid: Int
    do {
        practiced = sc.nextInt()
    } while (sc.hasNextInt() && practiced !in 1..200000)
    do {
        paid = sc.nextInt()
    } while (sc.hasNextInt() && paid !in 1..200000)
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
        //var startPoint = 0//비교 시작지점
        for(startPoint in 0 until practiced-1){
            var remainPaid = paid //남아있는 지불 기회
            var temp=0

            for (i in startPoint until practiced - 1) {
                if((actualDays[i+1]-actualDays[i]-1)>paid) {//차이가 paid보다 클 경우 로직.
                    longestStreakLength= maxOf(longestStreakLength, paid+1)
                    startPoint+1
                    break
                }
                var currentStreakLength = actualDays[i + 1] - actualDays[i] + 1 //지불 여부 상관없이 연속일 수
                var actualPaid = minOf(currentStreakLength - 2, paid)//실제 지불한 일 수 , paid가 최대가 되어야함으로 minOf를 통해 구함
                currentStreakLength -= remainPaid // 지불일수를 제외한 연속 일 수
                remainPaid -=actualPaid//사용한 지불 횟수 ( 남은 지불 횟수)
                if(actualDays[i+1]-actualDays[i]-1>remainPaid&&remainPaid==0) {
                    longestStreakLength++
                    startPoint+1
                    break
                }
                longestStreakLength= maxOf(longestStreakLength, currentStreakLength+actualPaid+remainPaid) //기존 , 제외한 연속 일수 + 실제 지불 수 , 최대값 구하기
            }
        }
        return longestStreakLength
    }
    println(findLongestStreak(practiced, paid, actualDays))
}