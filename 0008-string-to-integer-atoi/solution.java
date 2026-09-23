class Solution {
    public int myAtoi(String s) {
        // 32-bit integer range
        int INT_MAX = Integer.MAX_VALUE; // 2147483647
        int INT_MIN = Integer.MIN_VALUE; // -2147483648

        int i = 0;
        int n = s.length();

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check sign
        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            // If '-' found, make sign negative
            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        // Step 3: Convert digits to number
        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            // Convert current character to digit
            int digit = s.charAt(i) - '0';

            /*
             * Step 4: Check overflow before adding digit
             *
             * Example:
             * result = 214748364
             * digit = 8
             *
             * result * 10 + digit > INT_MAX
             */
            if (result > (INT_MAX - digit) / 10) {

                // Return max/min value if overflow happens
                return (sign == 1) ? INT_MAX : INT_MIN;
            }

            // Build the number
            result = result * 10 + digit;

            i++;
        }

        // Apply sign and return
        return result * sign;
    }
}