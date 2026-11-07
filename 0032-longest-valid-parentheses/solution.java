class Solution {
    public int longestValidParentheses(String s) {
        
        // Stack stores indices of unmatched characters
        // We seed it with -1 as a base for length calculation
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                // Push the index of '(' onto the stack
                // We'll pop it when we find its matching ')'
                stack.push(i);
                
            } else {
                // We found a ')', so pop the top (trying to match it)
                stack.pop();
                
                if (stack.isEmpty()) {
                    // No matching '(' exists for this ')'
                    // This index becomes the new base boundary
                    stack.push(i);
                } else {
                    // Valid match found!
                    // Length = current index - index of last unmatched character
                    int validLen = i - stack.peek();
                    maxLen = Math.max(maxLen, validLen);
                }
            }
        }
        
        return maxLen;
    }
}