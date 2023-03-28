package chap6

class LazyTest {
    init {
        println("init block")
    }

    val subject by lazy { //초기화 발동하면 실행
        println("lazy initialized")
        "Kotlin Programming"
    }
    fun flow() {
        println("not initialized")
        println("subject one: $subject")//여기서 해당 subject 매소드 초기화
        println("subject two: $subject")
    }
}

fun main() {
    val test=LazyTest()
    test.flow() // flow 메소드 호출
}