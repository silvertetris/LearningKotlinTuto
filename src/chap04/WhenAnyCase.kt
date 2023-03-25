package chap04

fun main() {
    cases("Hello")
    cases(1)
    cases(System.currentTimeMillis())
}
fun cases(obj: Any) {
    when (obj) {
        1 -> println("Int: $obj")
        "Hello" -> println("String: $obj")
        is Long -> println("Long: $obj")
        !is String -> println("Not a String")
        else -> println("Unknown")
    }
}