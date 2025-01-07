import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()//integer
    val input: Array<Double> = Array(n) { 0.0 }
    for (i in 0 until n) {
        input[i] = sc.nextDouble()
    }

    val sum = input.sum()
    val avgProperty: Double = sum.toDouble() / n
    var bigSum = 0.0 //큰 놈들의 합
    var bigNum: Int = 0 //큰 놈들의 수
    for (i in 0 until n) {
        if (input[i] > avgProperty) {
            bigSum += input[i]
            bigNum++
        }//평균보다 많은 놈 도출
    }
    val y = (bigSum / sum)
    val x: Double = (bigNum.toDouble() / n)
    val differ = (y - x)*100
    println(String.format("%.6f", differ))
}