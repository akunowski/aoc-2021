fun main() {
    val input = readInput("main/resources/Day02")
    val solution = Day02()
    println(solution.part1(input))
    println(solution.part2(input))
}

class Day02 {
    private val INPUT_REGEX = """(forward|down|up)\s(\d)""".toRegex()

    fun part1(input: List<String>) = calculateCourse(Submarine1(), input)

    fun part2(input: List<String>) = calculateCourse(Submarine2(), input)

    private fun calculateCourse(submarine: Submarine, input: List<String>): Int {
        input
                .map { it.parseCommand() }
                .forEach {
                    when (it.first) {
                        "forward" -> submarine.forward(it.second)
                        "down" -> submarine.down(it.second)
                        "up" -> submarine.up(it.second)
                        else -> println("something went terribly wrong")
                    }
                }
        return submarine.result()
    }

    private fun String.parseCommand(): Pair<String, Int> {
        val (command, value) = INPUT_REGEX.find(this)?.destructured ?: error("error while destructing")
        return Pair(command, value.toInt())
    }

    interface Submarine {
        fun forward(value: Int)
        fun down(value: Int)
        fun up(value: Int)
        fun result(): Int
    }

    class Submarine1(var horizontal: Int = 0, var depth: Int = 0) : Submarine {
        override fun forward(value: Int) {
            this.horizontal += value
        }

        override fun down(value: Int) {
            this.depth += value
        }

        override fun up(value: Int) {
            this.depth -= value
        }

        override fun result() = this.depth * this.horizontal
    }

    class Submarine2(var horizontal: Int = 0, var depth: Int = 0, var aim: Int = 0) : Submarine {
        override fun forward(value: Int) {
            this.horizontal += value
            this.depth += value * aim
        }

        override fun down(value: Int) {
            this.aim += value
        }

        override fun up(value: Int) {
            this.aim -= value
        }

        override fun result() = this.depth * this.horizontal

    }
}