import java.util.*
import kotlin.math.abs
import kotlin.math.floor

fun main() {
    val sc = Scanner(System.`in`)
    val result = ArrayList<String>()
    while (true) {
        val input = sc.nextLine()
        if (input == "-1 00:00:00") break

        val parts = input.split(" ")
        val targetAngle = parts[0].toInt()
        val timeParts = parts[1].split(":").map { it.toInt() }
        var hour = timeParts[0]
        var minute = timeParts[1]
        var second = timeParts[2]

        var currentTimeInSeconds = hour * 3600 + minute * 60 + second

        while (true) {
            // Calculate the angles at the current time
            val hourAngle = ((hour % 12) * 30 + (minute / 2.0) + (second / 120.0)) % 360
            val minuteAngle = ((minute * 6) + (second / 10.0)) % 360
            val calculatedAngle = (minuteAngle - hourAngle + 360) % 360

            // If the calculated angle matches the target, stop
            if (floor(calculatedAngle) == targetAngle.toDouble()) break

            // Increment time by one second
            currentTimeInSeconds++
            hour = (currentTimeInSeconds / 3600) % 24
            minute = (currentTimeInSeconds % 3600) / 60
            second = currentTimeInSeconds % 60
        }

        // Format the time
        result.add(String.format("%02d:%02d:%02d", hour, minute, second))
    }

    // Print all results
    for (res in result) {
        println(res)
    }
}
