class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If opening bracket, push to stack
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } 
            // If closing bracket
            else {
                if (top == -1) return false; // stack empty

                char last = stack[top--];

                if ((c == ')' && last != '(') ||
                    (c == '}' && last != '{') ||
                    (c == ']' && last != '[')) {
                    return false;
                }
            }
        }

        return top == -1; // stack should be empty
    }
}