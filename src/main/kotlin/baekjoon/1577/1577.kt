import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val k = br.readLine().toInt()

    // DP 배열을 BigInteger로 선언하여 큰 수를 처리
    val dp = Array(m + 1) { Array<BigInteger>(n + 1) { BigInteger.ZERO } }

    // 공사중인 도로 정보 저장
    val blockedRight = mutableSetOf<Pair<Int, Int>>() // 오른쪽 방향 막힌 도로
    val blockedDown = mutableSetOf<Pair<Int, Int>>()  // 아래쪽 방향 막힌 도로

    for (i in 0 until k) {
        val (a, b, c, d) = br.readLine().split(" ").map { it.toInt() }

        // (a, b) -> (c, d) 방향이 막힌 도로는 오른쪽 또는 아래쪽
        if (a == c) {  // 가로 방향
            if (b < d) {
                blockedRight.add(Pair(a, b)) // (a, b)에서 오른쪽으로 가는 도로가 막힘
            } else {
                blockedRight.add(Pair(c, d)) // (c, d)에서 오른쪽으로 가는 도로가 막힘
            }
        } else {  // 세로 방향
            if (a < c) {
                blockedDown.add(Pair(a, b)) // (a, b)에서 아래로 가는 도로가 막힘
            } else {
                blockedDown.add(Pair(c, d)) // (c, d)에서 아래로 가는 도로가 막힘
            }
        }
    }

    // 시작점 초기화
    dp[0][0] = BigInteger.ONE

    // DP 계산
    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 && j == 0) continue // 시작점은 이미 초기화 되어 있으므로 건너뜀
            // 오른쪽에서 올 수 있는 경우 (왼쪽에서 올 수 있음)
            if (j > 0 && !blockedRight.contains(Pair(i, j - 1))) {
                dp[i][j] += dp[i][j - 1]
            }

            // 아래에서 올 수 있는 경우 (위에서 올 수 있음)
            if (i > 0 && !blockedDown.contains(Pair(i - 1, j))) {
                dp[i][j] += dp[i - 1][j]
            }
        }
    }

    // 결과 출력
    print(dp[m][n])
}
