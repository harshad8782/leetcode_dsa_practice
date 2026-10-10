class Solution {
    public int removeDuplicates(int[] nums) {
        int off=0;
        int cm=1;
        int res=1;
        int n=nums.length;
        while(cm<n)
        {
            if (nums[cm]==nums[cm-1])
            {
                cm++;
                continue;
            }
            nums[off+1]=nums[cm];
            off++;
            cm++;
            res++;
        }
        return res;
    }
}