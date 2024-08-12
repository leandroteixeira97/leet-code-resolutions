/**
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore, it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(177));
        System.out.println(solution(1771));
        System.out.println(solution(1995555991));
    }

    public static boolean solution(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        String abc = x + "0";
        String cba = "0" + x;

        int j = abc.length() - 1;

        for (int i = 0; i < abc.length(); i ++) {
            if (abc.charAt(i) != cba.charAt(j)) {
                return false;
            }

            j--;
        }

        return true;
    }
}
