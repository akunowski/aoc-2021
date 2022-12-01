fun main() {
    val input = readInput("main/resources/Day01_2022")
    val solution = Day01_2022()
    println(solution.part1(input))
    println(solution.part2(input))
}

class Day01_2022 {
    fun part1(input: List<String>): Int {
        var max = 0
        var current = 0
        input
                .asSequence()
                .forEach {
                    if(it != "")
                        current += it.toInt()
                    else{
                        max = Math.max(max, current)
                        current = 0
                    }
                }
        return max
    }

    fun part2(input: List<String>): Int {
        val solution = mutableListOf<Int>()
        var current = 0
        input
                .asSequence()
                .forEach {
                    if(it != "")
                        current += it.toInt()
                    else{
                        solution.add(current)
                        println(solution.size)
                        current = 0
                    }
                }
        return solution.sortedDescending().take(3).sum()
    }
}
