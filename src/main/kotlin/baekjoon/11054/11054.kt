fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr:Array<Pair<Long, Long>> = Array(n) { Pair(0, 0) }

    for(i in 0 until n) {
        val temp = br.readLine().split(" ").map { it.toLong() }
        arr[i] = temp[0] to temp[1]
    }

    arr.sortWith(compareBy<Pair<Long, Long>> { it.second }.thenBy { it.first })
    var cnt = 1
    var prev = arr[0].second
    for(i in 1 until n) {
        if(arr[i].first>=prev) {
            cnt++
            prev = arr[i].second
        }
    }
    print(cnt)
}