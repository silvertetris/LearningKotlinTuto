package chap5

open class A{
    open fun f() = println("A Class f()")
    fun a() = println("A Class a()")
}

interface B {
    fun f() = println("B Interface f()")
    fun b() = println("B Interface b()")
}

class C: A(), B {
    override fun f() = println("C Class f()")

    fun test() {
        f()
        b()
        super<A>.f() //상속 받은 게 A 클래스와 B 인터페이스 f 메소드가 중복되니까 구분하기 위해 < > 괄호 사용
        super<B>.f()
    }
}

fun main() {
    val c=C()
    c.test()
}