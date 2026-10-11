class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case:
        // If dividend = Integer.MIN_VALUE (-2147483648)
        // and divisor = -1,
        // answer becomes 2147483648 which is outside int range.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of result
        // true if result should be negative
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to long and make them positive
        // We use long because abs(Integer.MIN_VALUE) overflows in int
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        // Repeatedly subtract divisor using bit shifting
        while (dvd >= dvs) {

            long temp = dvs; // current divisor multiple
            int multiple = 1;

            /*
             Double temp until it becomes larger than dividend.
             temp << 1 means temp * 2
             multiple << 1 means multiple * 2
            */
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract largest found multiple
            dvd -= temp;

            // Add corresponding multiple to answer
            quotient += multiple;
        }

        // Apply sign
        return isNegative ? -quotient : quotient;
    }
}