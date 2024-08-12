import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger {
    static Map<Character, Integer> valueMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);

        int val = 0;

        List<Character> iAble = Arrays.asList('V', 'X');
        List<Character> xAble = Arrays.asList('L', 'C');
        List<Character> cAble = Arrays.asList('D', 'M');

        Character lastChar = null;

        for(int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int value = valueMap.get(currentChar);

            if (currentChar == 'I' && iAble.contains(lastChar)) {
                value = -1;
            } else if (currentChar == 'X' && xAble.contains(lastChar)) {
                value= - 10;
            } else if (currentChar == 'C' && cAble.contains(lastChar)) {
                value= - 100;
            }

            val += value;
            lastChar = currentChar;
        }

        return val;
    }
}
