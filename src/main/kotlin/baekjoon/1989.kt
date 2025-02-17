import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val wr = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    val tree:Array<Triple<Pair<BigInteger,Int>, Int, Int>> = Array(4 * n) { Triple(Pair(BigInteger.ZERO, Int.MAX_VALUE), 0, 0) }
    fun minQuery(node: Int, left: Int, right: Int, b: Int, c: Int): Int {
        if (c < left || right < b) {
            return Int.MIN_VALUE
        } else if (b <= left && right <= c) {
            return tree[node].first.first.toInt()
        } else {//각 좌, 우 에서 최소값 찾음 -> 쪼개져서 최소 받고 그중에 비교
            val mid = (left + right) / 2
            val leftMin = minQuery(node * 2, left, mid, b, c)
            val rightMin = minQuery(node * 2 + 1, mid + 1, right, b, c)
            return minOf(leftMin, rightMin)
        }
    }
    fun treeInit(node: Int, left: Int, right: Int) { //구간합 트리 초기화
        if (left == right) { //트리의 리프노드에 모든 arr을 담을 거임
            tree[node] = Triple(Pair(arr[left].toBigInteger(),minQuery(1, 0, n-1, left, right)), left, right)
        } else {
            val mid = (left + right) / 2 //각 노드의 중간 인덱스 값
            treeInit(2 * node, left, mid)//좌측 노드

            treeInit(2 * node + 1, mid + 1, right) //우측 노드
            tree[node] = Triple(Pair(tree[2 * node].first.first + tree[2 * node + 1].first.first, minQuery(1, 0, n-1, left, right)), left, right)
        }
    }

    treeInit(1, 0, n - 1)
    var maxVal = BigInteger.ZERO
    var inx = Pair(0, 0)
    for(i in tree.indices) {
        if(tree[i].first.first*tree[i].first.second.toBigInteger() > maxVal) {
            inx = Pair(tree[i].second, tree[i].third)
            maxVal=tree[i].first.first*tree[i].first.second.toBigInteger()
        }
    }
    println(maxVal)
    print("${inx.first} ${inx.second}")
}