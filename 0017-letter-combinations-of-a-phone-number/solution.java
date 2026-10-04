class Solution {
    public List<String> letterCombinations(String digits) {
// Final answer list
        List<String> result = new ArrayList<>();

        // If input is empty, return empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }

        // Mapping of digits to letters
        String[] map = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        // Start backtracking from index 0
        backtrack(digits, 0, new StringBuilder(), result, map);

        return result;
    }

    // Backtracking function
    private void backtrack(String digits, int index,
                           StringBuilder current,
                           List<String> result,
                           String[] map) {

        // Base case:
        // If current combination length equals digits length
        // add it to result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for current digit
        String letters = map[digits.charAt(index) - '0'];

        // Try every letter
        for (char ch : letters.toCharArray()) {

            // Add current letter
            current.append(ch);

            // Move to next digit
            backtrack(digits, index + 1, current, result, map);

            // Remove last letter (backtrack)
            current.deleteCharAt(current.length() - 1);
        }
    }
}