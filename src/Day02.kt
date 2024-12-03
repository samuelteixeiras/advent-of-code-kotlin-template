import kotlin.math.abs

fun main() {

    fun islineSafe(numbers: List<Int>) : Boolean {
        var prev = 0;
        var safe = true;
        var numOrder = numbers[1] - numbers[0]

        run breaking@{
            numbers.forEach {
                if (prev == 0) {
                    prev = it
                } else {

                    val order = it - prev
                    if (numOrder > 0 && order < 0) {
                        safe = false
                        return@breaking
                    }

                    if (numOrder < 0 && order > 0) {
                        safe = false
                        return@breaking
                    }

                    val diff = abs(it - prev)
                    if (diff > 3 || diff < 1) {
                        safe = false
                        return@breaking
                    }

                    prev = it
                }
            }
        }
        return safe
    }



    var lines = readInput("files/day02")
    var total = 0

    lines.forEach(
        fun(line: String) {
            var numbers = line.split(" ").map { it.toInt() }

            if (islineSafe(numbers)) {
                println("Safe: $numbers")
                total += 1
            } else {
                println("Not safe: $numbers")
            }
        }
    )

    print(total)

    // part 2
    lines.forEach(
        fun(line: String) {
            var numbers = line.split(" ").map { it.toInt() }
            var safe = false;
            for (i in 0..numbers.lastIndex) {
                safe = islineSafe(numbers.toMutableList().apply { removeAt(i) })
                if (safe) {
                    println("Safe: $numbers")
                    total += 1
                    break
                }
            }
        }
    )

    print(total)
}