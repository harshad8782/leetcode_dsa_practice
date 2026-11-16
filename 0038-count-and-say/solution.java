class Solution {
    public String countAndSay(int n) {
        // Base case: first term is always "1"
        String result = "1";

        // Generate sequence from 2 to n
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1; // count of current repeating character

            // Traverse the previous result string
            for (int j = 1; j < result.length(); j++) {
                // If same character repeats, increase count
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    // If different character found:
                    // append count and previous character
                    temp.append(count);
                    temp.append(result.charAt(j - 1));

                    // reset count for new character
                    count = 1;
                }
            }

            // Handle the last group of characters
            temp.append(count);
            temp.append(result.charAt(result.length() - 1));

            // Update result for next iteration
            result = temp.toString();
        }

        // Return nth term
        return result;
    }
}