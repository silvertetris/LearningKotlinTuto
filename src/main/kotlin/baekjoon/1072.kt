import kotlin.math.*
fun main() {
    val(x, y) = readln().split(" ").map { it.toDouble() }
    if(x<=y) {
        print(-1)
        return
    }
    var currentPercentage = (y/x)*100 //남은 퍼센트 구하기 ㄱㄴ
    val onePercentage = (1/x)*100 // 1판 할떄마다 오르는 퍼센트
    //그러면 1-currentPercentage에서 정수부분 뺌
    val temp = currentPercentage.toInt()
    currentPercentage-=temp
    currentPercentage = 1-currentPercentage
    //여기서 부터 이분 탐색 적용
    var initPow = 9 //자리수
    while(true) {
        if(currentPercentage+onePercentage*(10.0.pow(initPow))>1) {
            initPow--
        }
        else {
            break
        }
    }
    var result = 10.0.pow(initPow+1).toInt()-1
    while(true) {
        var digitIdx = initPow
        result -= 10.0.pow(digitIdx).toInt()
        if(onePercentage*result +currentPercentage>1) {

        }
    }


}