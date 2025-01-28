fun main() {
    val n = readln().toInt()
    var result = 1
    for(i in n downTo 1) {
        val temp = (result * i).toString() //곱한수
        var len = i.toString().length//이거 만큼만 반복
        var iter = temp.length-1
        var str=""
        while(len != 0) {
            if(temp[iter] != '0') {
                str+=temp[iter]
                iter--
                len--
            }
            else {
                iter--
            }
        }
        result=str.reversed().toInt()
    }
    print(result)
}