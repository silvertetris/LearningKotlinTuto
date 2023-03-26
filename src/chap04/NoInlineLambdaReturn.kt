package chap04

fun main() {
    retFunc1()
}

fun retFunc1() {
    println("start of retFunc")
    inlineLambda(13, 3) lit@{a, b->
        val result=a+b
        if(result>10) return@lit
        println("result: $result")
    }
    println("end of retFunc")
}