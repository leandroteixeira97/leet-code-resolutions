import java.util.Objects;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));
        System.out.println(isValid("(){}[]["));
        System.out.println(isValid("(){}[["));
        System.out.println(isValid("BANANA"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Objects.equals('(', c) || Objects.equals('[', c) || Objects.equals('{', c)) {
                characterStack.push(c);
                continue;
            }

            if (Objects.equals(')', c) || Objects.equals(']', c) || Objects.equals('}', c)) {
                if (characterStack.isEmpty()) {
                    return false;
                }

                char peek = characterStack.peek();

                switch (c) {
                    case ')':
                        if (!Objects.equals(peek, '(')) {
                            return false;
                        }
                        break;
                    case ']':
                        if (!Objects.equals(peek, '[')) {
                            return false;
                        }
                        break;
                    case '}':
                        if (!Objects.equals(peek, '{')) {
                            return false;
                        }
                        break;
                }

                characterStack.pop();
            }
        }

        return characterStack.isEmpty();
    }
}
