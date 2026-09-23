class Solution {
    public String convert(String s, int numRows) {
        // If only 1 row, no zigzag needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create array of strings for rows
        String[] rows = new String[numRows];

        // Initialize all rows with empty string
        for (int i = 0; i < numRows; i++) {
            rows[i] = "";
        }

        int currentRow = 0;

        // true = moving down
        // false = moving up
        boolean goingDown = true;

        // Traverse each character
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Add character to current row
            rows[currentRow] += ch;

            // If reached bottom row
            // change direction upward
            if (currentRow == numRows - 1) {
                goingDown = false;
            }

            // If reached top row
            // change direction downward
            else if (currentRow == 0) {
                goingDown = true;
            }

            // Move row pointer
            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        // Combine all rows
        String result = "";

        for (int i = 0; i < numRows; i++) {
            result += rows[i];
        }

        return result;
    }
}