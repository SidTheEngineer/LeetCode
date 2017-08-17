import java.util.ArrayList;
import java.util.Arrays;

// Given an array S of n integers, are there elements a, b, c, and d in S such that
// a + b + c + d = target? Find all unique quadruplets in the array which gives the
// sum of target.

// Brute force: Exhaustively search through all possible combinations of 4 elements
// of the array and check if they add up to the target.

// Example:
// S = [1, 0, -1, 0, -2, 2]
// [
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
// ]

// This solution is based on the solution for 3sum. We simply add another position to check (j counter)
// and kill duplicates along the way by skipping over them.

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> solutions = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            // Some break/continue cases to speed things up.
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break; // No reason to continue when smallest possible choices > target
            if (nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue; // largest possible > target
            if (i > 0 && nums[i] == nums[i - 1]) continue; // No duplicates!

            for (int j = i + 1; j < nums.length - 2; j++) {

                // Some break/continue cases to speed things up.
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break; // smallest possible > target
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue; // largest possible < target
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // No duplicates!

                int start = j + 1, end = nums.length - 1;
                
                while (start < end) {
                    int a = nums[i], b = nums[j], c = nums[start], d = nums[end];
                    if ((a+b+c+d) < target) {
                        ++start;
                    } else if ((a+b+c+d) > target) {
                        --end;
                    } else {
                        solutions.add(Arrays.asList(a, b, c, d));
                        while (start < end && nums[start] == nums[start + 1]) ++start; // No duplicates!
                        while (start < end && nums[end] == nums[end - 1]) --end; // No duplicates!
                        ++start;
                        --end;
                    }
                }
            }
        }
        return solutions;
    }
}