
fun main() {
    var lines = readInput("files/day03")

    // find all matches for mul(digits,digits)
    val regex = """mul\((?<first>\d+),(?<second>\d+)\)""".toRegex()
    var total = 0
//    lines.map{ line:String ->
//        var matchResult = regex.find(line)
//
//        if (matchResult != null) {
//            while(matchResult?.groups?.get("first") != null) {
//                val first = matchResult.groups["first"]?.value?.toInt()
//                val second = matchResult.groups["second"]?.value?.toInt()
//                total += first!! * second!!
//
//                matchResult = matchResult.next()
//            }
//        }
//    }
//    println(total)

    // part 2

    val regex2 = """don't.*?do\(\)""".toRegex()
    val regex3 = """don't.*$""".toRegex()

    total = 0;
    lines.map{ line:String ->
        println(line)
        var replaced = line.replace(regex2, "")
        replaced = replaced.replace(regex3, "")
        println(replaced)
        println("------")
        var matchResult = regex.find(replaced)

        if (matchResult != null) {
            while(matchResult?.groups?.get("first") != null) {
                val first = matchResult!!.groups["first"]?.value?.toInt()
                val second = matchResult!!.groups["second"]?.value?.toInt()
                total += first!! * second!!

                matchResult = matchResult!!.next()
            }
        }
    }

    println(total)
}