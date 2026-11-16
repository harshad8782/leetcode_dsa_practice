class Solution {
    public int searchInsert(int[] nums, int target) {
        // Start pointer
        int left = 0;

        // End pointer
        int right = nums.length - 1;

        // Binary Search
        while (left <= right) {

            // Find middle index
            int mid = left + (right - left) / 2;

            // If target is found, return its index
            if (nums[mid] == target) {
                return mid;
            }

            // If target is greater, search in right half
            else if (nums[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller, search in left half
            else {
                right = mid - 1;
            }
        }

        // If target is not found,
        // 'left' will be the correct insert position
        return left;
    }
}