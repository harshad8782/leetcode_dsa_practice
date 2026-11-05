class Solution {

    public void nextPermutation(int[] nums) {

        int n = nums.length;

        // Step 1:
        // Find first decreasing element from right
        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2:
        // If found, find next greater element from right
        if (i >= 0) {

            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap both elements
            swap(nums, i, j);
        }

        // Step 3:
        // Reverse the right part
        reverse(nums, i + 1, n - 1);
    }

    // Function to swap two numbers
    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // Function to reverse array part
    private void reverse(int[] nums, int start, int end) {

        while (start < end) {

            swap(nums, start, end);

            start++;
            end--;
        }
    }
}