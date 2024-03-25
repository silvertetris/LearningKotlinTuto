package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var practiced: Int
    var paid: Int


    do {
        val (p, q) = br.readLine().split(" ").map { it.toInt() }
        practiced = p
        paid = q
    } while (practiced !in 1..200000 || paid !in 1..200000)

    val actualDays = IntArray(practiced)
    var num =0
    do{
        val days =br.readLine().split(" ").map { it.toInt() }
        for(i in 0 until practiced) {
            actualDays[i]=days[i]
            num++
        }
    } while (actualDays[num-1] !in 0..1000000)
    //begins logic
    var longestStreakLength = 0//최대 길이
    for (startPoint in 0 until practiced - 1) {
        var remainPaid = paid //남아있는 지불 기회
        var temp = 0
        for (i in startPoint until practiced - 1) {
            var currentStreakLength = actualDays[i + 1] - actualDays[i] + 1 //지불 여부 상관없이 연속일 수
            if ((currentStreakLength - 2) > remainPaid) {//차이가 paid보다 클 경우 로직.
                longestStreakLength = maxOf(longestStreakLength, temp + remainPaid + 1)
                startPoint + 1
                break
            }
            val actualPaid = minOf(currentStreakLength - 2, paid)//실제 지불한 일 수 , paid가 최대가 되어야함으로 minOf를 통해 구함
            currentStreakLength -= remainPaid // 지불일수를 제외한 연속 일 수
            remainPaid -= actualPaid//사용한 지불 횟수 ( 남은 지불 횟수)
            temp += (currentStreakLength + actualPaid)
            longestStreakLength = maxOf(longestStreakLength, temp + remainPaid) //기존 , 제외한 연속 일수 + 실제 지불 수 , 최대값 구하기
        }
    }
    println(longestStreakLength)
}