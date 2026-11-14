import java.util.*;

class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        // Prefix sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        int ans = Integer.MAX_VALUE;

        // Try all subarrays
        for (int i = 0; i < n; i++) {
            for (int len = l; len <= r; len++) {
                if (i + len <= n) {
                    int sum = prefix[i + len] - prefix[i];

                    if (sum > 0) {
                        ans = Math.min(ans, sum);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}