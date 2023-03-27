package chap6

import java.util.*

class User(_id: Int, _name: String, _age: Int) {
    val id: Int=_id
    var name: String = _name
        set(value) {
            println("The name was changed")
            field= value.uppercase(Locale.getDefault())
        }
    var age: Int=_age
}

fun main() {
    val user1=User(1, "Kildong", 35)
    user1.name="coco"
    println("user3.name=${user1.name}")
}