fun main() {
    var arr = MutableList<Int>(10001) {0}
    val n = readln().toInt()
    fun dp(n:Int):Int {
        if(n==0||n==1) return n
        if(arr[n]!=0) return arr[n]
        arr[n]=dp(n-1) + dp(n-2)
        return arr[n]
    }
    print(dp(n))
}