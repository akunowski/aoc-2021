import spock.lang.Specification

class Day03Spec extends Specification {
    Day03 day
    List<String> TEST_INPUT

    def setup() {
        day = new Day03()
        TEST_INPUT =
                [
                        "00100",
                        "11110",
                        "10110",
                        "10111",
                        "10101",
                        "01111",
                        "00111",
                        "11100",
                        "10000",
                        "11001",
                        "00010",
                        "01010"
                ]
    }

    def "Part1"() {
        when:
        def result = day.part1(TEST_INPUT)

        then:
        result == 198
    }

    def "Part2"() {
        when:
        def result = day.part2(TEST_INPUT)

        then:
        result == 230
    }
}