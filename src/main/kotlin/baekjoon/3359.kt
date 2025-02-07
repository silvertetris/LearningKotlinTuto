import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr: Array<Pair<Int, Int>> = Array(n) { Pair(0, 0) }
    for (i in 0 until n) {
        val temp = br.readLine().trim().split(" ").map { it.toInt() }
        arr[i] = Pair(temp[0], temp[1])
    }

    fun dp(index: Int, line: Int, rec: Boolean): Int {
        if (index == n) return 0
        if (rec) {
            val sum = arr[index].first + abs(line - arr[index].second)
            return maxOf(sum + dp(index + 1, arr[index].second, false), sum+dp(index + 1, arr[index].second, true))
        } else {
            val sum = arr[index].second + abs(line - arr[index].first)
            return maxOf(sum + dp(index + 1, arr[index].first, true), sum+dp(index + 1, arr[index].first, false))
        }
    }
    print(maxOf(dp(1, arr[0].first, true) + arr[0].second, dp(1, arr[0].second, false) + arr[0].first))
}