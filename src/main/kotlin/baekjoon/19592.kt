fun main() {
    val t = readln().toInt()
    val bw = System.out.bufferedWriter()

    fun binarySearch(max: Int, me: Int, y:Int, x:Int): Int {
        var answer = -1
        var low = 0
        var high = y
        var vTime: Float = x.toFloat()/max
        while (low <= high) {
            val mid = (low + high) / 2
            val afterBoost = x - mid //1초후 부스트 쓰고 남은 거리
            var meTime:Float = afterBoost.toFloat()/me+1.0f
            if (meTime > vTime) {
                low=mid+1
            } else if (meTime < vTime) {
                high=mid-1
            } else {
                answer = mid
                break
            }
        }
        return if(answer<y) answer+1
        else -1
    }
    repeat(t) {
        val (n, x, y) = readln().split(" ").map { it.toInt() }
        var v = readln().split(" ").map { it.toInt() }.toMutableList()
        val me = v.last()
        v.removeLast()
        v.sort()
        val max = v.last()
        if (max < me) {
            bw.write("0\n")
        } else {
            bw.write("${binarySearch(max, me, y, x)}\n")
        }
    }
    bw.flush()
    bw.close()
}