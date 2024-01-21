import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String my_string) {
        int[] numbers = my_string.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .sorted()
                .toArray();

        return numbers;
    }
}
