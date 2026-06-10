import java.util.Stack;

class valid {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Closing brackets
            else {

                // If stack empty
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check matching
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // Stack should be empty
        return stack.isEmpty();
    }
}
