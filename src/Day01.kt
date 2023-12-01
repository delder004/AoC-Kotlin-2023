fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (line in input) {
            val digits = line.filter { it.isDigit() }
            val total = digits.first().toString() + digits.last().toString()
            sum += total.toInt()
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for (line in input) {
            println(line)
            val wordNums = mapOf(
                "zero" to "0",
                "one" to "1",
                "two" to "2",
                "three" to "3",
                "four" to "4",
                "five" to "5",
                "six" to "6",
                "seven" to "7",
                "eight" to "8",
                "nine" to "9"
            )
            var word = ""
            var digits = ""
            for (letter in line) {
                if (letter.isDigit()) {
                    println(letter)
                    digits += letter
                    word = ""
                } else {
                    word += letter
                    if (word in wordNums.keys) {
                        println(word)
                        digits += wordNums[word]
                        word = letter.toString()
                    } else if (word.substring(1) in wordNums.keys) {
                        println(word.substring(1))
                        digits += wordNums[word.substring(1)]
                        word = letter.toString()
                    } else {
                        for (num in wordNums.keys) {
                            if (num in word) {
                                digits += wordNums[num]
                                word = letter.toString()
                            }
                        }
                    }
                }
            }
            val total = digits.first().toString() + digits.last().toString()
            sum += total.toInt()
            println(digits)
            println(sum)
        }
        println(sum)
        return sum
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val testInput2 = readInput("Day01Part2Test")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
