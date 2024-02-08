import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        //숫자비교
        Comparator<String> numberComparator = 
            (s1, s2) -> (s2 + s1).compareTo(s1 + s2);

        List<String> numStrings = new ArrayList<>();
        for (int num : numbers) {
            numStrings.add(Integer.toString(num));
        }

        numStrings.sort(numberComparator);

        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrings) {
            sb.append(numStr);
        }

        if (numStrings.get(0).equals("0")) return "0";
        else return sb.toString();
    }
}
