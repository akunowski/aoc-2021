import spock.lang.Specification

class Day01Spec extends Specification {

    Day01 day01
    List<String> DAY_1_INPUT

    def setup() {
        day01 = new Day01()
        DAY_1_INPUT =
                [
                        "199",
                        "200",
                        "208",
                        "210",
                        "200",
                        "207",
                        "240",
                        "269",
                        "260",
                        "263"
                ]
    }

    def "Part1"() {
        given:
        def input_part_1 =
                [
                        "199",
                        "200",
                        "208",
                        "210",
                        "200",
                        "207",
                        "240",
                        "269",
                        "260",
                        "263"
                ]

        when:
        def result = day01.part1(input_part_1)

        then:
        result == 7
    }

    def "Part2"() {
        given:
        def input_part_1 =
                [
                        "199",
                        "200",
                        "208",
                        "210",
                        "200",
                        "207",
                        "240",
                        "269",
                        "260",
                        "263"
                ]

        when:
        def result = day01.part2(input_part_1)

        then:
        result == 5
    }
}
