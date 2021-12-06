fun main() {
    val input = readInput("main/resources/Day01")
    val solution = Day01()
    println(solution.part1(input))
    println(solution.part2(input))
}

class Day01 {
    fun part1(input: List<String>): Int {
        return input
                .asSequence()
                .map { it.toInt() }
                .zipWithNext { a, b ->
                    if (a < b) 1
                    else 0
                }
                .sum()
    }

    fun part2(input: List<String>): Int {
        return input
                .asSequence()
                .map { it.toInt() }
                .windowed(3, 1, false) { it.sum() }
                .zipWithNext { a, b ->
                    if (a < b) 1
                    else 0
                }
                .sum()
    }
}
