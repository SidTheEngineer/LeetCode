public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int maxSoFar = nums[0], newMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // If including the element is beneficial, we will
            // check if the new max is greater than previous max, else we will
            // check if that element (new max) is greater than our max so far.
            // If it is, then we will simply start with that new element.
            newMax = Math.max(newMax + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, newMax);
        }
        return maxSoFar;
    }
}