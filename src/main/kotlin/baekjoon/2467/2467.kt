import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    var pair = Pair(0, 0)
    var result = Int.MAX_VALUE
    if((arr[0]<0 && arr[n-1]<0) || (arr[0]>0 && arr[n-1]>0)) {
        if(abs(arr[0]+arr[1]) > abs(arr[n-1]+arr[n-2])) {
            print("${arr[n-2]} ${arr[n-1]}")
        } else {
            print("${arr[0]} ${arr[1]}")
        }
        return
    }
    for (i in arr.indices - 2) {
        var l = i + 1
        var r = n - 1
        while (l <= r) {
            val mid = (l + r) / 2
            if (arr[mid] + arr[i] <= 0) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        if (abs(arr[l - 1] + arr[i]) < result) {
            result = abs(arr[l - 1] + arr[i])
            pair = Pair(arr[i], arr[l - 1])
        }
    }
    bw.write("${pair.first} ${pair.second}")
    bw.flush()
    bw.close()
}