package day02

import readInput
import println

fun main() {
    fun part1(input: List<String>): Int {

        val bag = mapOf("red" to 12, "green" to 13, "blue" to 14)

        var sumIds = 0
        for (line in input) {
            val gameId = line.split(":")[0].split(" ")[1].toInt()
            val sets = line.split(":")[1].split(";")
            var isPossible = true
            for (set in sets) {
                val cubes = set.split(",")
                for (cube in cubes) {
                    val (num, color) = cube.trim().split(" ")
                    if (bag[color] == null) {
                        isPossible = false
                    } else if (bag[color]!! < num.toInt()) {
                        isPossible = false
                    }
                }
            }
            if (isPossible) {
                sumIds += gameId
            }
        }
        return sumIds
    }

    fun part2(input: List<String>): Int {
        var powers = 0
        for (line in input) {
            val maxes = mutableMapOf("red" to 0, "green" to 0, "blue" to 0)
            val sets = line.split(":")[1].split(";")
            for (set in sets) {
                val cubes = set.split(",")
                for (cube in cubes) {
                    val (num, color) = cube.trim().split(" ")
                    if (num.toInt() > maxes[color]!!) {
                        maxes[color] = num.toInt()
                    }
                }
            }
            powers += maxes.values.reduce { acc, i -> acc * i }
        }
        return powers
    }

    val testInput = readInput("day02/Day02_test")
    check(part1(testInput) == 8)

    val testInput2 = readInput("day02/Day02Part2Test")
    check(part2(testInput2) == 2286)

    val input = readInput("day02/Day02")
    part1(input).println()
    part2(input).println()
}
