import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    sc.nextLine()
    val factors6 = "739739"
    val factors7 = "9739739"
    val input: ArrayList<String> = ArrayList<String>()
    val result: ArrayList<String> = ArrayList<String>()
    for (i in 0 until n) {
        input.add(sc.nextLine())
    }

    for (i in 0 until n) {
        var products: Int = 0
        var index: Int = 0
        if (input[i].length == 6) {
            for (j in 0 until 6) {
                val digit = input[i][j].code - 48
                if (digit == 15) {
                    index = j
                    continue
                }
                products += digit * (factors6[j].code - 48)
            }
            for (j in 0..9) {
                val multiplied = (factors6[index].code - 48) * j
                if ((products + multiplied) % 10 == 0) {
                    var arr: CharArray = input[i].toCharArray()
                    arr[index] = (j + 48).toChar()
                    result.add(String(arr))
                    break
                }
            }
        }
        else{
            for (j in 0 until 7) {
                val digit = input[i][j].code - 48
                if (digit == 15) {
                    index = j
                    continue
                }
                products += digit * (factors7[j].code - 48)
            }
            for (j in 0..9) {
                val multiplied = (factors7[index].code - 48) * j
                if ((products + multiplied) % 10 == 0) {
                    var arr: CharArray = input[i].toCharArray()
                    arr[index] = (j + 48).toChar()
                    result.add(String(arr))
                    break
                }
            }
        }

    }

    for (i in 0 until n) {
        println("Scenario #${i + 1}:")
        println(result[i])
        if (i != n - 1) {
            println()
        }
    }
}