import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()
    val a = reader.readLine().split(" ").map { it.toLong() }.toTypedArray()
    val b = reader.readLine().split(" ").map { it.toLong() }.toTypedArray()
    val q = reader.readLine().toInt()
    val w = reader.readLine().split(" ").map { it.toInt() }.toTypedArray()
    reader.close()
    val dif = MutableList(n) { 0L }
    for (i in 0 until n) {
        dif[i] = a[i] - b[i]
    }
    for (i in 0 until q) {
        var cnt = 0
        for (j in 0 until n) {
            if (dif[j] < w[i]) {
                break
            } else cnt++
        }
        writer.write("${cnt}\n")
    }
    writer.flush()
    writer.close()
}
