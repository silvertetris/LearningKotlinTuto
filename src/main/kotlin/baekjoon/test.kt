import kotlin.system.measureNanoTime


fun main() {
    val n = 1_000_000
    val wealthList = List(n) { (1..1_000_000_000).random().toLong() }
    fun alternativeApproach(wealth: List<Long>): Double {
        val sortedWealth = wealth.sortedDescending()
        val sum = sortedWealth.sum()
        val avgProperty = sum.toDouble() / wealth.size
        var bigSum = 0.0
        var bigNum = 0

        for (i in sortedWealth.indices) {
            if (sortedWealth[i] > avgProperty) {
                bigSum += sortedWealth[i]
            } else {
                bigNum = i
                break
            }
        }

        val y = (bigSum / sum)
        val x = (bigNum.toDouble() / wealth.size)
        return (y - x) * 100
    }

    fun greedyApproach(wealth: List<Long>): Double {
        val sortedWealth = wealth.sortedDescending()
        val totalWealth = sortedWealth.sum()
        var bigSum = 0L
        var maxDifference = 0.0

        for (i in sortedWealth.indices) {
            bigSum += sortedWealth[i]
            val y = bigSum.toDouble() / totalWealth
            val x = (i + 1).toDouble() / wealth.size
            maxDifference = maxOf(maxDifference, y - x)
        }

        return maxDifference * 100
    }

    val time1 = measureNanoTime { println("1: ${greedyApproach(wealthList)}") }
    val time2 = measureNanoTime { println("2: ${alternativeApproach(wealthList)}") }

    println("1 Time: ${time1 / 1_000_000.0} ms")
    println("2 Time: ${time2 / 1_000_000.0} ms")
}




