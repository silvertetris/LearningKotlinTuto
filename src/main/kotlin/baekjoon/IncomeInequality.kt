import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val input: Array<Float> = Array(n) { 0.0f }
    for (i in 0 until n) {
        input[i] = sc.nextFloat()
    }

    val sum = input.sum()
    val avgProperty: Double = sum.toDouble() / n
    var bigSum: Int = 0
    var bigNum: Int = 0
    for (i in 0 until n) {
        if (input[i] > avgProperty) {
            bigSum += input[i].toInt()
            bigNum++
        }//평균보다 많은 놈 도출
    }
    val y = (bigSum.toDouble() / sum) * 100
    val x: Double = (bigNum.toDouble() / n) * 100
    val differ = abs(y - x)
    println(String.format("%.6f", differ))
}