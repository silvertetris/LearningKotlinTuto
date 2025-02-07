fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map{it.toInt() }.toMutableList()
    arr.sort()
    var result = 0
    result += n*n*arr[0]*2
    if(n>=2) {
        result+=(n-2)*(n-2) *arr[0]*3
        result += 4*(n-2)*arr[1]
        result+=(n-2)*2*arr[0]
    }

    result+=(4*n-4)*arr[1]
    result+=4*arr[2]
    print(result)
}