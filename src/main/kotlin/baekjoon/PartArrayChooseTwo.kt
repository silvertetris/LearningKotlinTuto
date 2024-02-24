package baekjoon

import java.util.*

fun main() {
    fun sum(array: IntArray, a: Int, b: Int): Int {
        var temp = 0
        if (a == b) {
            temp = array[a] + array[b]
            return temp
        } else {
            for (i in a .. b) {
                temp += array[i]
            }
        }
        return temp
    }

    fun findMin(array: IntArray, a:Int, b:Int):Int {
        val size = b-a+1
        var temp=IntArray(size)
        for(i in 1 until b-a) {
            temp[i]=array[a+i]
        }
        temp.sort()
        return temp[0]
    }

    val sc = Scanner(System.`in`)
    val n: Int = sc.nextInt()//첫 n 입력
    sc.nextLine()//줄 초기화
    val num = IntArray(n)//배열 num 선언 용량 = n
    for (i in 0 until n) {//1부터 n번까지 입력 반복
        while (num[i] !in 1..n) {
            num[i] = sc.nextInt()
        }
    }
    println("N=$n\n")
    println("num=${num.toList()}")

    for (i in 0 until n) {
        for (j in i until n) {
            println(sum(num, i, j))
            println("$i $j")
            println(findMin(num, i, j))
            println("\n")
        }
    }

}