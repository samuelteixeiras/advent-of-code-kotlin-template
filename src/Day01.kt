import kotlin.math.abs


fun main() {
        var lines = readInput("files/day01")
        val (left, right) = lines.map{ line:String ->

                var first = line.substringBefore(" ").toInt();
                var second = line.substringAfter(" ").trim().toInt();
                first.toLong() to second.toLong()
        }.unzip()



        var result = left.sorted().zip(right.sorted()).map{ (left, right) ->
            // when you don't know abs function in ktl , we use this.
            // if (left - right < 0 ) (left - right) * -1 else left - right
            abs(left - right)
        }.sum()

        println(result)

        // similarity
//        val myHashMap = hashMapOf<Int, Int>()
//        left.sorted().forEach { left ->
//                if (!myHashMap.containsKey(left) ) {
//                        myHashMap[left] = 0
//                }
//        }
//
//        right.sorted().forEach { right ->
//                if (myHashMap.containsKey(right) ) {
//                        print("what")
//                        myHashMap[right] = myHashMap[right]!! + 1
//                }
//        }
//        var total = 0;
//        for ((key, value) in myHashMap) {
//                println("key = $key, value = $value")
//                total += key * value
//        }
//        println(total)

        // using ktl for real
        val freq : Map<Long, Int> = right.groupingBy{ it }.eachCount()
        left.fold(0L) { acc, num -> acc + num * freq.getOrDefault(num, 0) }
                .also(::println)




}


