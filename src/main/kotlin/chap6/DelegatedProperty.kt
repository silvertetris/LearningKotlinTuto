package chap6

import kotlin.properties.Delegates

class User2{
    var name: String by Delegates.observable("NONAME") {
        prop, old, new ->
        println("$old -> $new")
    }
}

fun main() {
    val user=User2()
    user.name="Kildong"
    user.name="Dooly"
}