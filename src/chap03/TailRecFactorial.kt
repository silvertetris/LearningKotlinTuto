package chap03

fun main() {
    val number=5
    println("Factorial: $number-> ${factorial(number)}")
}

tailrec fun factorial(n: Int, run: Int=1): Long { //tailrec 스택 재활용, 스택 오버플로우 x (메모리)
    return if(n==1) run.toLong() else factorial(n-1, run*n)
}