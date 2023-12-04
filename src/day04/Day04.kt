package day04

import readInput
import println

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 4361)

    val testInput2 = readInput("Day03Part2Test")
    check(part2(testInput2) == 281)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
