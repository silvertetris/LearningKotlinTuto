fun main() {
    val br= System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val a = Array(n) { Pair(0, 0) }
    for(i in 0 until n) {
        var temp = br.readLine().split(" ").map { it.toInt() }
        a[i] = Pair(temp[0], temp[1])
    }
    a.sortBy { it.first }
    if(n==1) {
        print(1)
        return
    }
    var answer = 0
    var remain = 0

    for(i in 1 until n) {
        if(a[i].first-a[i-1].second <=remain) {
            continue
        }
        remain = a[i].first-a[i-1].first
        if(a[i].first-a[i-1].first > a[i].second) {
            answer ++
            continue
        }
    }
    print(answer+1)
}