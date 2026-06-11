import java.util.Stack;

class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If digit, build number
            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');
            }

            // If + sign
            else if (ch == '+') {

                result += sign * number;
                number = 0;
                sign = 1;
            }

            // If - sign
            else if (ch == '-') {

                result += sign * number;
                number = 0;
                sign = -1;
            }

            // If opening bracket
            else if (ch == '(') {

                // Store current result
                stack.push(result);

                // Store current sign
                stack.push(sign);

                // Reset for new calculation
                result = 0;
                sign = 1;
            }

            // If closing bracket
            else if (ch == ')') {

                result += sign * number;
                number = 0;

                // First pop sign
                result *= stack.pop();

                // Then add previous result
                result += stack.pop();
            }
        }

        // Add remaining number
        result += sign * number;

        return result;
    }
}
