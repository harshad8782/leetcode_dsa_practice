import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            // Check if current string is valid
            if (isValid(current)) {
                result.add(current);
                found = true;
            }

            // If we already found valid strings,
            // don't remove any more characters.
            if (found) {
                continue;
            }

            // Try removing each parenthesis
            for (int i = 0; i < current.length(); i++) {

                char ch = current.charAt(i);

                // We only remove parentheses
                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next = current.substring(0, i)
                           + current.substring(i + 1);

                // Avoid duplicates
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return result;
    }

    // Checks whether parentheses are balanced
    private boolean isValid(String s) {

        int count = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                count++;
            } 
            else if (ch == ')') {
                count--;

                // More ')' than '('
                if (count < 0) {
                    return false;
                }
            }
        }

        // Valid only if all '(' are matched
        return count == 0;
    }
}
