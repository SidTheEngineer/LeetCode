// Given an array S of n integers, find three integers in S such that the sum
// is closest to a given number, target. Return the sum of the three integers.
// You may assume that each input would have exactly one solution.

// "Smallest difference between the sum of 3 numbers and the target."

// Brute force: try every possible combination of 3 digits and look
// for the smallest difference.

// Idea: Sort the array of nums and do a 3 pointer sweep.

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) return nums[0] + nums[1] + nums[2];

        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);

        // This for loop covers all positions our left pointer can be in.
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;

            // This while loop assures our pointers cannot cross each other.
            // when this while loop breaks, we move to the next position
            // for our left pointer.
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) end--;
                else start++;

                // If the distance between the new sum and the target is less than
                // the distance between the old sum and the target, update the new
                // smallest difference.
                if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            }
        }

        return result;
    }
}