class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } 
            else if (c == ')') {
                min--;
                max--;
            } 
            else { // '*'
                min--; // treat * as ')'
                max++; // treat * as '('
            }

            // Too many ')'
            if (max < 0) {
                return false;
            }

            // min can't be negative
            min = Math.max(min, 0);
        }

        return min == 0;
    }
}
