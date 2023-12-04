package day03

import readInput
import println

fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        // check the first row (mid and bot)
        var top: String? = null
        var mid = input[0]
        var bot: String? = input[1]
        var nums = mid.split(Regex("\\D+")).filter { it.isNotEmpty() }

        for (num in nums) {
            var isPart = false
            val begIdx = mid.indexOf(num)
            val endIdx = begIdx + num.length - 1

            // check to the left above and below of beginning idx
            // left
            if (begIdx > 0) {
                if (mid[begIdx - 1].toString() != ".") {
                    if (!mid[begIdx - 1].isDigit()) {
                        isPart = true
                    }
                }
                // bottom left
                if (bot!![begIdx -1].toString() != ".") {
                    if (!bot[begIdx - 1].isDigit()) {
                        isPart = true
                    }
                }
            }
            // bottom
            if (bot!![begIdx].toString() != ".") {
                if (!bot[begIdx].isDigit()) {
                    isPart = true
                }
            }
            // bottom right
            if (bot[begIdx + 1].toString() != ".") {
                if (!bot[begIdx + 1].isDigit()) {
                    isPart = true
                }
            }


            // check to the right top and bottom of ending idx
            // right
            if (endIdx < mid.length - 1) {
                if (mid[endIdx + 1].toString() != ".") {
                    if (!mid[endIdx + 1].isDigit()) {
                        isPart = true
                    }
                }
                // bottom right
                if (bot[endIdx + 1].toString() != ".") {
                    if (!bot[endIdx + 1].isDigit()) {
                        isPart = true
                    }
                }
            }
            // bottom
            if (bot[endIdx].toString() != ".") {
                if (!bot[endIdx].isDigit()) {
                    isPart = true
                }
            }
            // bottom left
            if (bot[endIdx - 1].toString() != ".") {
                if (!bot[endIdx - 1].isDigit()) {
                    isPart = true
                }
            }

            if (isPart) {
                sum += num.toInt()
            }
        }

        // check the second up to next to last rows
        var lineIdx = 2
        while (lineIdx <= input.size - 1) {
            // create the window
            top = input[lineIdx - 2]
            mid = input[lineIdx - 1]
            bot = input[lineIdx]
            nums = mid.split(Regex("\\D+")).filter { it.isNotEmpty() }
            val regex = Regex("\\d+")
            val indices = regex.findAll(mid).map { it.range.first to it.range.last }.toList()
            val zipped = nums.zip(indices)


            // check mid for part numbers
            for ((num, idxs) in zipped) {
                var isPart = false
                val (begIdx, endIdx) = idxs

                // check to the left above and below of beginning idx
                // left
                if (begIdx > 0) {
                    if (mid[begIdx - 1].toString() != ".") {
                        if (!mid[begIdx - 1].isDigit()) {
                            isPart = true
                        }
                    }
                    // bottom left
                    if (bot[begIdx -1].toString() != ".") {
                        if (!bot[begIdx - 1].isDigit()) {
                            isPart = true
                        }
                    }
                    // top left
                    if (top[begIdx -1].toString() != ".") {
                        if (!top[begIdx - 1].isDigit()) {
                            isPart = true
                        }
                    }
                }
                // top
                if (top[begIdx].toString() != ".") {
                    if (!bot[begIdx].isDigit()) {
                        isPart = true
                    }
                }
                // bottom
                if (bot[begIdx].toString() != ".") {
                    if (!bot[begIdx].isDigit()) {
                        isPart = true
                    }
                }
                // bottom right
                if (bot[begIdx + 1].toString() != ".") {
                    if (!bot[begIdx + 1].isDigit()) {
                        isPart = true
                    }
                }
                // top right
                if (top[begIdx + 1].toString() != ".") {
                    if (!top[begIdx + 1].isDigit()) {
                        isPart = true
                    }
                }

                // check to the right top and bottom of ending idx
                // right
                if (endIdx < mid.length - 1) {
                    if (mid[endIdx + 1].toString() != ".") {
                        if (!mid[endIdx + 1].isDigit()) {
                            isPart = true
                        }
                    }
                    // bottom right
                    if (bot[endIdx + 1].toString() != ".") {
                        if (!bot[endIdx + 1].isDigit()) {
                            isPart = true
                        }
                    }
                    // upper right
                    if (top[endIdx + 1].toString() != ".") {
                        if (!top[endIdx + 1].isDigit()) {
                            isPart = true
                        }
                    }
                }
                // top
                if (top[endIdx].toString() != ".") {
                    if (!top[endIdx].isDigit()) {
                        isPart = true
                    }
                }
                // bottom
                if (bot[endIdx].toString() != ".") {
                    if (!bot[endIdx].isDigit()) {
                        isPart = true
                    }
                }
                // bottom left
                if (bot[endIdx - 1].toString() != ".") {
                    if (!bot[endIdx - 1].isDigit()) {
                        isPart = true
                    }
                }
                // top left
                if (top[endIdx - 1].toString() != ".") {
                    if (!top[endIdx - 1].isDigit()) {
                        isPart = true
                    }
                }

                if (isPart) {
                    sum += num.toInt()
                }
            }

            // increment the window
            lineIdx++
        }

        top = input[input.size - 2]
        mid = input[input.size - 1]
        bot = null
        nums = mid.split(Regex("\\D+")).filter { it.isNotEmpty() }

        for (num in nums) {
            var isPart = false
            val begIdx = mid.indexOf(num)
            val endIdx = begIdx + num.length - 1

            // check to the left above and below of beginning idx
            // left
            if (begIdx > 0) {
                if (mid[begIdx - 1].toString() != ".") {
                    if (!mid[begIdx - 1].isDigit()) {
                        isPart = true
                    }
                }
                // top left
                if (top[begIdx - 1].toString() != ".") {
                    if (!top[begIdx - 1].isDigit()) {
                        isPart = true
                    }
                }
            }
            // top
            if (top[begIdx].toString() != ".") {
                if (!top[begIdx].isDigit()) {
                    isPart = true
                }
            }
            // top right
            if (top[begIdx + 1].toString() != ".") {
                if (!top[begIdx + 1].isDigit()) {
                    isPart = true
                }
            }

            // check to the right top and bottom of ending idx
            // right
            if (endIdx < mid.length - 1) {
                if (mid[endIdx + 1].toString() != ".") {
                    if (!mid[endIdx + 1].isDigit()) {
                        isPart = true
                    }
                }
                // upper right
                if (top[endIdx + 1].toString() != ".") {
                    if (!top[endIdx + 1].isDigit()) {
                        isPart = true
                    }
                }
            }
            // top
            if (top[endIdx].toString() != ".") {
                if (!top[endIdx].isDigit()) {
                    isPart = true
                }
            }
            // top left
            if (top[endIdx - 1].toString() != ".") {
                if (!top[endIdx - 1].isDigit()) {
                    isPart = true
                }
            }

            if (isPart) {
                println(num)
                sum += num.toInt()
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("day03/Day03_test")
    check(part1(testInput) == 4361)

    val testInput2 = readInput("day03/Day03Part2Test")
    check(part2(testInput2) == 467835)

    val input = readInput("day03/Day03")
    part1(input).println()
    part2(input).println()
}
