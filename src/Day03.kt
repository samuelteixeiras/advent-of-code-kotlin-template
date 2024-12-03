fun main() {
    val lines = readInput("day03")

    // find all matches for mul(digits,digits)
    val regex = """mul\((?<first>\d{1,3}),(?<second>\d{1,3})\)""".toRegex()
    var total = 0
    lines.map{ line:String ->
        var matchResult = regex.find(line)

        if (matchResult != null) {
            while(matchResult?.groups?.get("first") != null) {
                val first = matchResult.groups["first"]?.value?.toInt()
                val second = matchResult.groups["second"]?.value?.toInt()
                total += first!! * second!!

                matchResult = matchResult.next()
            }
        }
    }
    println(total)

    // part 2
    total = 0
    var enabled = true
    val mul = """mul\((?<first>\d{1,3}),(?<second>\d{1,3})\)"""
    val doReg = """do\(\)"""
    val dontReg = """don't\(\)"""
    """$mul|$doReg|$dontReg""".toRegex().findAll(lines.joinToString()).forEach { match ->
        when (match.value) {
            "don't()" -> enabled = false
            "do()" -> enabled = true
            else -> if (enabled) {
                val first = match.groups["first"]!!.value.toInt()
                val second = match.groups["second"]!!.value.toInt()

                total += first * second
            }
        }
    }

    println(total)
}