package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

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
        var remainPaid = paid //남아있는 지불 기회 startPoint가 올라갈떄마다 remainPaid는 초기화 되어야함.
        for (i in startPoint until practiced - 1) {
            var currentStreakLength = actualDays[i + 1] - actualDays[i] + 1 //지불 여부 상관없이 연속일 수
            if ((currentStreakLength - 2) > remainPaid&&(currentStreakLength-2>0)) {//차이가 paid보다 클 경우 로직. 배제
                longestStreakLength = maxOf(longestStreakLength, i-startPoint+paid+1)
                startPoint + 1
                break
            }
            val haveToPay = currentStreakLength-2//지불해야하는 일 수
            if(haveToPay>remainPaid) {//남은 일 수 보다 지불해야 하는 일 수 가 많은 경우. 배제
                longestStreakLength= maxOf(longestStreakLength, i-startPoint+paid+1)
                startPoint+1
                break
            }

            if((remainPaid==0)&&(currentStreakLength-2>0)) {//남은 지불일 수가 남지 않았지만 지불해야할 날이 있을 경우
                longestStreakLength=maxOf(longestStreakLength, i-startPoint+paid+1)
                startPoint+1
                break
            }
            remainPaid-=haveToPay
        }
    }
    if(longestStreakLength==0) longestStreakLength=practiced+paid
    println(longestStreakLength)
}