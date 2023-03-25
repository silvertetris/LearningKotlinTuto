package chap04

fun main() {
    print("Enter the lines: ")
    val n=readLine()!!.toInt()

    for(line in 1..n) {
        for(space in 1..(n-line)) print(" ")
        for(star in 1 until 2*line) print("*") //until=범위 전체 말고 미만까지
        println("\n")
    }
}