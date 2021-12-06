import spock.lang.Specification

class Day02Spec extends Specification {
    Day02 day02
    List<String> TEST_INPUT

    def setup() {
        day02 = new Day02()
        TEST_INPUT =
                [
                        "forward 5",
                        "down 5",
                        "forward 8",
                        "up 3",
                        "down 8",
                        "forward 2"

                ]
    }

    def "Part1"() {
        when:
        def result = day02.part1(TEST_INPUT)

        then:
        result == 150
    }

    def "Part2"() {
        when:
        def result = day02.part2(TEST_INPUT)

        then:
        result == 900
    }
}