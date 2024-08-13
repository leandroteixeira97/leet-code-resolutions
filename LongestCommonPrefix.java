import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder longestPrefix = new StringBuilder();

        Arrays.sort(strs, Comparator.comparing(String::length));

        List<String> sortedList = Arrays.asList(strs);

        for (int i = 0; i < strs[0].length(); i ++) {
            String c = strs[0].charAt(i) + "";
            final String comparator = longestPrefix.toString() + c;

            List<String> filteredList = sortedList.stream()
                .filter(w -> w.startsWith(comparator))
                .collect(Collectors.toList());

            if (filteredList.size() == sortedList.size()) {
                longestPrefix.append(c);
            } else {
                return longestPrefix.toString();
            }
        }

        return longestPrefix.toString();
    }
}
