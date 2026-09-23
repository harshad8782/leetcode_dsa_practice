class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        // Step 1: Merge both arrays
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Step 2: Add remaining elements
        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        // Step 3: Find median
        int n = merged.length;

        // Odd length
        if (n % 2 == 1) {
            return merged[n / 2];
        }
        // Even length
        else {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        }
    }
}