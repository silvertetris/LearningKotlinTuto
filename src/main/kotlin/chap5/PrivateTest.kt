package chap5

private class PrivateClass {
    private var i=1
    private fun privateFunc() {
        i+=1
    }
    fun access() {
        privateFunc()
    }
}

class Otherclass {
    private val a=PrivateClass()
    fun test() {
        val pc=PrivateClass()
        pc.access()
    }
}

fun main() {
    val pc=PrivateClass()

}