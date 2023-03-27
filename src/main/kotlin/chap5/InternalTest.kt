package chap5

internal class InternalClass { //같은 모듈이면 어디든 가능
    internal var i=1
    internal fun icFunc() {
        i+=1
    }
    fun access() {
        icFunc()
    }
}

class Other {
    internal val ic=InternalClass()
    fun test() {
        ic.i
        ic.icFunc()
    }
}
fun main() {
    val mic=InternalClass()
    mic.i
    mic.icFunc()
}