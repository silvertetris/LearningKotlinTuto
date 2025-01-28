fun main() {
    val (n, k) = readln().split(' ').map { it.toLong() }
    var acc = 0L
    var ans = 0

    for (i in 1L..n) {
        acc = ((0 until i.toString().length).fold(acc) { total, _ -> total * 10L } + i) % k

        if (acc == 0L) ++ans
    }

    println(ans)
}