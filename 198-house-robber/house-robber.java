class Solution {
    public int rob(int[] nums) {
        int prev = 0;
        int curr = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = curr;

            curr = Math.max(curr, prev + nums[i]);

            prev = temp;
        }

        return curr;
    }
}
