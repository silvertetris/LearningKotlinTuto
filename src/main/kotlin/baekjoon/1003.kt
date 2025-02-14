fun main() {
    val t = readln().toInt()
    var arr = Array(41) {0L}
    fun dp(num:Int):Long {
        if(num==0) {
            ++arr[0]
            return 0
        }
        else if(num==1) {
            ++arr[1]
            return 1
        }
        else if(arr[num]!=0L) {
            return arr[num]
        }
        else {
            arr[num] = dp(num-1) + dp(num-2)
            return arr[num]
        }
    }
    val result = StringBuilder()
    for(i in 0 until t) {
        val n = readln().toInt()
        dp(n)
        result.append("${arr[0]} ${arr[1]}\n")
        arr= Array(41){0}
    }
    print(result)
}