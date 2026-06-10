import java.util.Stack;

class Solution {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If digit
            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');
            }

            // Plus sign
            else if (ch == '+') {

                result += sign * number;
                number = 0;
                sign = 1;
            }

            // Minus sign
            else if (ch == '-') {

                result += sign * number;
                number = 0;
                sign = -1;
            }

            // Opening bracket
            else if (ch == '(') {

                // Save current result and sign
                stack.push(result);
                stack.push(sign);

                // Reset
                result = 0;
                sign = 1;
            }

            // Closing bracket
            else if (ch == ')') {

                result += sign * number;
                number = 0;

                // First pop sign
                result *= stack.pop();

                // Then add previous result
                result += stack.pop();
            }
        }

        // Add last number
        result += sign * number;

        return result;
    }
}
