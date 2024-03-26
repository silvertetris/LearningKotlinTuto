package baekjoon

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

lateinit var actualDays: IntArray //지연 선언

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var longestStreakLength = 0//최대 길이
    var startPoint = 0
    var practiced: Int
    var paid: Int
    do {
        val (p, q) = br.readLine().split(" ").map { it.toInt() }
        practiced = p
        paid = q
    } while (practiced !in 1..200000 || paid !in 1..200000)
    actualDays = IntArray(practiced)
    var num = 0
    do {
        val days = br.readLine().split(" ").map { it.toInt() }
        for (i in 0 until practiced) {
            actualDays[i] = days[i]
            num++
        }
    } while (actualDays[num - 1] !in 0..1000000)

    //begins logic
    var endReached = false
    while (startPoint <= practiced - 2 && !endReached) {
        var remainPaid = paid //남아있는 지불 기회 startPoint가 올라갈떄마다 remainPaid는 초기화 되어야함.
        for (i in startPoint + 1 until practiced) {
            val gap = actualDays[i] - actualDays[i - 1] - 1 //차이
            if(remainPaid<gap) { //차이가 지불일수를 넘을 경우
                if(i==startPoint+1) {//1. 처음부터 넘을 경우 (최대 길이가 0이기 때문에 정해줌)
                    longestStreakLength= maxOf(longestStreakLength, paid+1)
                }
                break // 2. 끝자락에서 넘을 경우 (i를 올릴 필요가 없기에 탈출)
            }
            remainPaid -= gap
            longestStreakLength = maxOf(longestStreakLength, i - startPoint + paid + 1)
            if(i==practiced-1) { //i가 끝자락에 도달하면 아우터 반복문까지 탈출 (스타트 포인트를 옮길 필요 x)
                endReached=true
            }
        }
        startPoint++
    }
    bw.write("$longestStreakLength")
    bw.flush()
    bw.close()
}