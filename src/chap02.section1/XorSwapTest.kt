package chap02.section1

fun main() {
    var number1 = 12
    var number2 = 25

    number1=number1 xor number2
    number2=number1 xor number2
    number1=number1 xor number2

    println("number 1= " + number1)
    println("number 2= " + number2)
}