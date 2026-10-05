import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int inside = stack.pop();
                
                if (inside == 0) {
                    inside = 1; // ()
                } else {
                    inside = 2 * inside; // (A)
                }

                stack.push(stack.pop() + inside);
            }
        }

        return stack.pop();
    }
}
