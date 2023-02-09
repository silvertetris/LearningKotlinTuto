package chap02.section1

fun main() {
    checkArg("Hello")
    checkArg(5)
}

fun checkArg(s: Any) {
    if(s is String) println("s is String: $s")

    if(s is Int) println("s is Int: $s")
}
