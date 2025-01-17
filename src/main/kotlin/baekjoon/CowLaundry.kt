import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var result = 0
    var list: ArrayList<Pair<Int, Int>> = ArrayList<Pair<Int, Int>>()
    repeat(n) {
        list.add(Pair(sc.nextInt(), sc.nextInt()))
    }

    list.sortBy { it.first }
    while (list[0].first != list[0].second) {
        if (list[0].first < list[0].second) { //top 이 bottom 보다 작을 때
            val sub = list[0].second - list[0].first
            result += sub
            for (j in list[0].first until list[0].second) {
                list[j] = Pair(list[j].first - 1, list[j].second)
            }
            list[0] = Pair(list[0].second, list[0].second)
        }
        list.sortBy { it.first }
    }
    println(result)
}