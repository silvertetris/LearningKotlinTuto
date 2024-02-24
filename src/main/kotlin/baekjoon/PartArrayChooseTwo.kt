package baekjoon

import java.util.*

fun main() {
    fun sum(array: IntArray, a: Int, b: Int): Int {
        var temp = 0
        if (a == b) {
            temp = array[a] + array[a]
            return temp
        } else {
            for (i in a..b) {
                temp += array[i]
            }
        }
        return temp
    }

    val sc = Scanner(System.`in`)
    val n: Int = sc.nextInt()
    sc.nextLine()
    val num = IntArray(n)
    for (i in 0..n) {
        while (num[i] !in 0..n) {
            num[i] = sc.nextInt()
        }
    }
    println("N=$n\n")
    println("num=${num.toList()}")

    for (i in 0..n) {
        for (j in i..n) {
            println(sum(num, i, j))
            println("\n$i $j")
        }
    }

}