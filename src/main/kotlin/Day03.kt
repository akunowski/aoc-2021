fun main() {
    val input = readInput("main/resources/Day03")
    val solution = Day03()
    println(solution.part1(input))
    println(solution.part2(input))
}

class Day03 {

    fun part1(input: List<String>): Int {
        val result = GammaRate()
        input.forEach {
            it.forEachIndexed { index, char -> result.addBit(index, char) }
        }
        val gamma = result.toGamma(input.size).toInt(2)
        val epsilon = result.toEpsilon(input.size).toInt(2)
        return gamma * epsilon
    }

    fun part2(input: List<String>) =
            oxygen(input).toInt(2) * CO2(input).toInt(2)

    private fun oxygen(diagnostic: List<String>) =
            calculateLifeSupport(diagnostic) { counter: Int, list: List<Any> -> if (counter * 2 >= list.size) '1' else '0' }

    private fun CO2(diagnostic: List<String>) =
            calculateLifeSupport(diagnostic) { counter: Int, list: List<Any> -> if (counter * 2 >= list.size) '0' else '1' }
}

fun calculateLifeSupport(diagnostic: List<String>, criteria: (Int, List<Any>) -> Char): String {
    var internalListOfDiagnostics = diagnostic
    var currentKey = 0
    var currentCriteria: Char
    do {
        var counter = 0
        internalListOfDiagnostics.forEach {
            if (it[currentKey] == '1') counter++
        }
        currentCriteria = criteria(counter, internalListOfDiagnostics)
        internalListOfDiagnostics = internalListOfDiagnostics.filter { it[currentKey] == currentCriteria }
        currentKey++
    } while (internalListOfDiagnostics.size != 1)

    return internalListOfDiagnostics.first()
}

class GammaRate(private val bits: MutableMap<Int, Int> = mutableMapOf()) {
    fun addBit(position: Int, bit: Char) {
        var value = bits.getOrDefault(position, 0)
        if (bit == '1') value += 1
        bits[position] = value
    }

    fun toGamma(size: Int): String =
            bits.values.map {
                if (it >= (size / 2)) "1"
                else "0"
            }.fold("") { current, next -> current + next }


    fun toEpsilon(size: Int): String =
            bits.values.map {
                if (it <= (size / 2)) "1"
                else "0"
            }.fold("") { current, next -> current + next }
}
