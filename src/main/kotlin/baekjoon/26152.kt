import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val width = mutableListOf<Pair<Int, Int>>()

    // 상단 장애물 입력
    for (i in 0 until n) {
        val A = scanner.nextInt()
        width.add(Pair(A, i))
    }

    // 하단 장애물 입력 및 틈새 크기 계산
    for (i in 0 until n) {
        val B = scanner.nextInt()
        width[i] = Pair(width[i].first - B, width[i].second)
    }

    // 틈새 크기를 기준으로 정렬
    width.sortBy { it.first }

    val q = scanner.nextInt()
    val birds = mutableListOf<Int>()

    // 플래피 버드 크기 입력
    for (i in 0 until q) {
        val bird = scanner.nextInt()
        birds.add(bird)
    }

    // 각 플래피 버드에 대해 결과 계산
    for (bird in birds) {
        var result = n
        if (bird > width[0].first) {
            result = rSearch(width, 0, width.size - 1, bird)
        }
        println("$result ")
    }
}

// 이진 탐색 함수
fun rSearch(width: List<Pair<Int, Int>>, l: Int, r: Int, w: Int): Int {
    val mid = (l + r) / 2
    if (l >= r) {
        return if (width[mid].first >= w) width[mid - 1].second else width[mid].second
    }
    return if (width[mid].first >= w) {
        rSearch(width, l, mid - 1, w)
    } else {
        rSearch(width, mid + 1, r, w)
    }
}