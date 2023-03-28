package chap6

interface Car {
    fun go() : String
}

class VanImple(val power: String): Car{ //클래스 생성 Car 상속받음
    override fun go() = "은 짐을 적재하며 $power 을 가집니다"
}
class  SprotImpl(val power: String): Car {
    override fun go() = "은 경주용에 사용되며 $power 을 가집니다."
}

class CarModel(val model: String, impl:Car): Car by impl{ //impl 객체에 대해 Car 인터페이스를 위임함
    fun carInfo() {
        println("$model ${go()}")//
    }
}

fun main() {
    val myDamas=CarModel("Damas 2010", VanImple("100마력"))
    val my350z=CarModel("350Z 2008", SprotImpl("350마력"))

    myDamas.carInfo()
    my350z.carInfo()
}