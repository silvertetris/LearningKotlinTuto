fun main() {
    /*
    만두피 안에 만두 속, 만두피 = 밀가루

만두 종류 = m , 밀가루 양 = n
만두 종류 = 1..m
i번째 만두를 만들 수 있는 최대
a sub i / b sub i

하나 만들면 n 에서 c sub i 를 빼야함
스페셜 만두는 just n 에서 c sub 0 를 빼면 됨

가격의 최대 값.;
어차피 최대 만두 갯수는 10개니까 maxOf(10개) 를 해도 시간초과가 안뜰거 같음

1. sub problems
dp[만두 갯수][남은 밀가루]
     */
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val(n, m, c0, d0) = br.readLine().split(" ").map{it.toInt()}
    repeat(m) {

    }
}