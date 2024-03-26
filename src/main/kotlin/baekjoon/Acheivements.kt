package baekjoon

import java.io.*

lateinit var actualDays:IntArray
var longestStreakLength = 0//최대 길이
var startPoint =0
var bool = false
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var practiced: Int
    var paid: Int
    do {
        val (p, q) = br.readLine().split(" ").map { it.toInt() }
        practiced = p
        paid = q
    } while (practiced !in 1..200000 || paid !in 1..200000)
    actualDays = IntArray(practiced)
    var num =0
    do{
        val days =br.readLine().split(" ").map { it.toInt() }
        for(i in 0 until practiced) {
            actualDays[i]=days[i]
            num++
        }
    } while (actualDays[num-1] !in 0..1000000)

    //begins logic
    while (startPoint<=practiced-2) {
        var remainPaid = paid //남아있는 지불 기회 startPoint가 올라갈떄마다 remainPaid는 초기화 되어야함.
        for (i in startPoint until practiced - 1) {
            val gap = actualDays[i + 1] - actualDays[i] -1 //차이
            if ((gap) > remainPaid&&(gap>0)) {//차이가 paid보다 클 경우 로직. 배제
                longestStreakLength = maxOf(longestStreakLength, i-startPoint+paid+1)
                break
            }
            if(gap>remainPaid) {//남은 일 수 보다 지불해야 하는 일 수 가 많은 경우. 배제
                longestStreakLength= maxOf(longestStreakLength, i-startPoint+paid+1)
                break
            }
            if(i==practiced-1) {
                if(remainPaid>0) {
                    longestStreakLength= maxOf(longestStreakLength, i-startPoint+paid+1)
                    break
                }
                longestStreakLength= maxOf(longestStreakLength, i-startPoint+paid+1)
                bool=true
                break
            }
            remainPaid-=gap

            longestStreakLength= maxOf(longestStreakLength, i-startPoint+paid+2)
        }
        if(bool) break
        startPoint++
    }
    bw.write("$longestStreakLength")
    bw.flush()
    bw.close()
}